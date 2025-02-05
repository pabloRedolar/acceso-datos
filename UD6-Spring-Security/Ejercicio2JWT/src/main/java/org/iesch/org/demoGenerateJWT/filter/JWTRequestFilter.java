package org.iesch.org.demoGenerateJWT.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.iesch.org.demoGenerateJWT.utilJWT.JWTutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JWTRequestFilter extends OncePerRequestFilter {

    @Autowired
    private JWTutil jwTutil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String autorizationHeader = request.getHeader("Autorization");

        System.out.println(autorizationHeader);

        String username = null;
        String jwt = null;

        if (autorizationHeader != null && autorizationHeader.startsWith("Bearer ")) {
            jwt = autorizationHeader.substring(7);
            username = jwTutil.extractUsername(jwt);
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            if (jwTutil.validaToken(jwt)) {
                
            }
        }



    }
}
