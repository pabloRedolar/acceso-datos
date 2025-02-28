package org.iesch.ad.LoginYJWT.controller;

import org.iesch.ad.LoginYJWT.jwtUtil.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/")
public class AdminController {

    @Autowired
    JWTUtil jwtUtil;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin") //Alguien con rol administrador verá este endpoint
    public ResponseEntity<?> helloAdmin(){
        return ResponseEntity.ok("Hola Admin");
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user")
    public ResponseEntity<?> helloUser(){
        return ResponseEntity.ok("Hola User");
    }
}
