package org.iesch.ad.demoFiltros_ModeloUsuario.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/public")
public class ZonaPublica {

    @GetMapping("/saludo")
    public ResponseEntity<?> slaudar() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("Saludo: ", "Hola desde Zona Publica");

        return ResponseEntity.ok(hashMap);
    }

}
