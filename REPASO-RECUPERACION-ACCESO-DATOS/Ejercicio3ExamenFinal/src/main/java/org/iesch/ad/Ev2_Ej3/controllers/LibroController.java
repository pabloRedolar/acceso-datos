package org.iesch.ad.Ev2_Ej3.controllers;

import org.iesch.ad.Ev2_Ej3.models.Libro;
import org.iesch.ad.Ev2_Ej3.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibroController {

    @Autowired
    LibroService libroService;

    @PostMapping("/libros")
    public ResponseEntity<?> crearLibro(@RequestBody Libro libro) {
        return ResponseEntity.ok(libroService.crearLibro(libro));
    }
    
    // Resto de operaciones CRUD


}
