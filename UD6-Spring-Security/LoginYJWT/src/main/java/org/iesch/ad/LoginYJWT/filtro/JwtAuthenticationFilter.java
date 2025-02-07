package org.iesch.ad.LoginYJWT.filtro;


import ch.qos.logback.core.util.StringUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.iesch.ad.LoginYJWT.jwtUtil.JWTutil;
import org.iesch.ad.LoginYJWT.service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;

public class JwtAuthenticationFilter extends OncePerRequestFilter {
    
    @Autowired
    JWTutil jwTutil;

    @Autowired
    CustomUserDetailService userDetailsService;
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //Obtener JWT de la peticion
        
        String token = getTokenFromRequest(request);

        //Validar el token
        if (StringUtils.hasText(token) && jwTutil.validaToken(token)) {
            //Busco el username con el token

            String usernmae = jwTutil.extractUsername(token);

            UserDetails userDetails = userDetailsService.loadUserByUsername(usernmae);

            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.getAuthorities()
            );

            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }

        filterChain.doFilter(request, response);
        
    }

    private String getTokenFromRequest(HttpServletRequest request) {
        String autorizationHeader = request.getHeader("Autorization");

//        System.out.println(autorizationHeader);

        if (StringUtils.hasText(autorizationHeader) && autorizationHeader.startsWith("Bearer ")) {
            return autorizationHeader.substring(7, autorizationHeader.length());
        }

        return null;
    }
}
