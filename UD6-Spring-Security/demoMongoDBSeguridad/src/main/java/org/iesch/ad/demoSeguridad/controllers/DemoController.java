package org.iesch.ad.demoSeguridad.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DemoController {

    @GetMapping("saludo")
    public ResponseEntity<?> saludar(){
        return ResponseEntity.ok(Map.of("Saludo a", "Pablo"));
    }
}
