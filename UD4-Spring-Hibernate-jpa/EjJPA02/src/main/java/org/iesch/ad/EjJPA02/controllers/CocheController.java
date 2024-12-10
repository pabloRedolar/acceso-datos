package org.iesch.ad.EjJPA02.controllers;

import org.iesch.ad.EjJPA02.services.CocheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CocheController {
    @Autowired
    CocheService cocheService;

    @GetMapping("/coches/menos-revisiones")
    public ResponseEntity<?> getCochesConMenosRevs() {
        return ResponseEntity.ok(cocheService.getCochesMenosRevs());
    }
}
