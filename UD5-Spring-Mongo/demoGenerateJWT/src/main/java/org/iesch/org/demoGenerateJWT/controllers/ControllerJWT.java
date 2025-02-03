package org.iesch.org.demoGenerateJWT.controllers;

import org.iesch.org.demoGenerateJWT.utilJWT.JWTutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerJWT {

    @Autowired
    private JWTutil JWTutil;

    @GetMapping("/genera/{username}")
    public String generarJsonWebToken(@PathVariable String username) {
        return JWTutil.generateToken(username);
    }
}
