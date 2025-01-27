package org.iesch.ad.crudpersonas.controllers;

import org.iesch.ad.crudpersonas.models.Persona;
import org.iesch.ad.crudpersonas.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonaController {

    @Autowired
    PersonaRepository personaRepository;

    @PostMapping("/api/persona")
    public ResponseEntity<?> crearPersona(@RequestBody List<Persona> personas) {
        return ResponseEntity.ok(personaRepository.saveAll(personas));
    }
}
