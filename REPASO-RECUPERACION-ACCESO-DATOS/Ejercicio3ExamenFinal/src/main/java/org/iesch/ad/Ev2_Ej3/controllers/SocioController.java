package org.iesch.ad.Ev2_Ej3.controllers;

import org.iesch.ad.Ev2_Ej3.models.Socio;
import org.iesch.ad.Ev2_Ej3.services.SocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SocioController {

    @Autowired
    SocioService socioService;

    @PostMapping("/socios")
    public ResponseEntity<?> crearSocio(@RequestBody Socio socio) {
        return ResponseEntity.ok(socioService.crearSocio(socio));
    }

    // Resto de operaciones CRUD

    // --------------------------------


    // Prestar un libro
    @PutMapping("/prestamos/prestar")
    public ResponseEntity<?> prestarLibro(@RequestParam String dni, @RequestParam String isbn) {

        if (socioService.prestarLibro(dni, isbn)) {
            return ResponseEntity.ok(true);
        } else return ResponseEntity.badRequest().body(false);

    }
}
