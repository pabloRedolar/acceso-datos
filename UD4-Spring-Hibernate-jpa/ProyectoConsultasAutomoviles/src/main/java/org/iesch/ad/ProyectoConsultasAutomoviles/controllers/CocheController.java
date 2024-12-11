package org.iesch.ad.ProyectoConsultasAutomoviles.controllers;

import org.iesch.ad.ProyectoConsultasAutomoviles.services.CocheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coche")

public class CocheController {
    @Autowired
    CocheService cocheService;

    @GetMapping("/menos-revisiones")
    public ResponseEntity<?> getCochesConMenosRevisiones() {
        return ResponseEntity.ok(cocheService.getCochesConMenosRevisiones());
    }

    @GetMapping("/matricula-revisiones")
    public ResponseEntity<?> getCochesMatriculaYRevisiones() {
        return ResponseEntity.ok(cocheService.getCochesMatriculaYRevisiones());
    }


}
