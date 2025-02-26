package org.iesch.ad.LoginYJWT.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class AdminController {

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
