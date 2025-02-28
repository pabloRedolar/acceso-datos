package org.iesch.ad.LoginYJWT.service;

import org.iesch.ad.LoginYJWT.dto.LoginDTO;
import org.iesch.ad.LoginYJWT.jwtUtil.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JWTUtil jwtUtil;

    public String login(LoginDTO loginDTO) {
        System.out.println("AuthService Login");
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDTO.getUsername(),
                        loginDTO.getPassword()
                ));

        System.out.println(authentication.toString());
        System.out.println();
        authentication.getAuthorities().forEach(System.out::println);
        System.out.println();
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return jwtUtil.generateToken(authentication);
    }

}
