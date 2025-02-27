package org.iesch.ad.EjerciciosBasicosSecurity.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PruebaController {

    @GetMapping("/hola")
    public ResponseEntity<?> saludo() {
        return ResponseEntity.ok("Hola que tal");
    }
}
