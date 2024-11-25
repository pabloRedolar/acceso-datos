package org.iesch.ad.EjemploBusquedasFeching.controller;

import org.iesch.ad.EjemploBusquedasFeching.servicios.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutorController {
    @Autowired
    AutorService autorService;

    @GetMapping("/api/autores")
    public ResponseEntity<?> devuelTodos() {
        return ResponseEntity.ok(autorService.devuelveTodos());
    }
}
