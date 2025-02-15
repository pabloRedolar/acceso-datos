package org.iesch.ad.LoginYJWT.controllers;

import org.iesch.ad.LoginYJWT.DTOs.JwtAuthResponse;
import org.iesch.ad.LoginYJWT.DTOs.LoginDTO;
import org.iesch.ad.LoginYJWT.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        System.out.println("Login");

        String token = authService.login(loginDTO);

        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
        jwtAuthResponse.setAccesToken(token);
        jwtAuthResponse.setTokenType("token");

        return ResponseEntity.ok(jwtAuthResponse);
    }
}
