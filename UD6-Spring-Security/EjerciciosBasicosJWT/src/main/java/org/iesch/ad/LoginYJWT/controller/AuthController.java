package org.iesch.ad.LoginYJWT.controller;

import org.iesch.ad.LoginYJWT.dto.JwtAuthResponse;
import org.iesch.ad.LoginYJWT.dto.LoginDTO;
import org.iesch.ad.LoginYJWT.jwtUtil.JWTUtil;
import org.iesch.ad.LoginYJWT.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        System.out.println("Login");
        String token = authService.login(loginDTO);
        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
        jwtAuthResponse.setAccessToken(token);
        jwtAuthResponse.setTokenType("jwt");
        return ResponseEntity.ok(jwtAuthResponse);
    }

    @GetMapping("/getClaims/{jwToken}")
    public ResponseEntity<?> getClaims(@PathVariable String jwToken) {

        return ResponseEntity.ok(jwtUtil.extractAllClaims(jwToken));

    }

//    @GetMapping("/createToken")
//    public ResponseEntity<?> createToken(@) {
//        return ResponseEntity.ok(jwtUtil.generateToken("pabloRedolar"));
//    }
}
