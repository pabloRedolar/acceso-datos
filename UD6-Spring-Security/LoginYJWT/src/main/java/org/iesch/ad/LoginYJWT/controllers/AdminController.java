package org.iesch.ad.LoginYJWT.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AdminController {
    @GetMapping("/admin") //alguien con rol admin vera esta pag
    public ResponseEntity<?> helloadmin() {
        return ResponseEntity.ok("Hola admin");
    }

    @GetMapping("/user")
    public ResponseEntity<?> helloauser() {
        return ResponseEntity.ok("Hola user");
    }
}
