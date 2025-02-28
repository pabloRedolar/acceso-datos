package org.iesch.ad.LoginYJWT.controller;

import org.iesch.ad.LoginYJWT.jwtUtil.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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


    // your-256-bit-secret-your-256-bit-secret

    // eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJwYWJsb1JlZG9sYXIiLCJuYW1lIjoiUGFibG8gUmVkb2xhciIsImlhdCI6MTUxNjIzOTAyMn0.m6qv2mb2GO43Gh0w3DvuLP-bQZs3-lxm-GQvdmkdSDw

    @GetMapping("/jwtbearer")
    public ResponseEntity<?> jwtbearer() {

        return ResponseEntity.ok("Hola funsiona");

    }
}
