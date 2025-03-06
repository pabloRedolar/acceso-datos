package org.iesch.ad.Ej2.controllers;

import org.iesch.ad.Ej2.models.dto.JwtAuthResponse;
import org.iesch.ad.Ej2.models.dto.LoginDTO;
import org.iesch.ad.Ej2.services.AuthService;
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
        jwtAuthResponse.setAccessToken(token);
        jwtAuthResponse.setTokenType("jwt");
        return ResponseEntity.ok(jwtAuthResponse);
    }
}
