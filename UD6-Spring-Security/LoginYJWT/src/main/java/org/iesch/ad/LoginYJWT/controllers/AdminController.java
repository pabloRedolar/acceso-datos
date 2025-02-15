package org.iesch.ad.LoginYJWT.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AdminController {
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin") //alguien con rol admin vera esta pag
    public ResponseEntity<?> helloadmin() {
        return ResponseEntity.ok("Hola admin");
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user")
    public ResponseEntity<?> helloauser() {
        return ResponseEntity.ok("Hola user");
    }
}
