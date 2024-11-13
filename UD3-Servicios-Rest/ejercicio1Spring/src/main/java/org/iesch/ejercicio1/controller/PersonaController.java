package org.iesch.ejercicio1.controller;

import org.iesch.ejercicio1.model.Persona;
import org.iesch.ejercicio1.service.GuardaPersonaFicheroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {
    @Autowired
    GuardaPersonaFicheroService guardaPersonaFicheroService;

    @PostMapping("/guardaUser")
    public Persona guardaUser(@RequestBody Persona persona){
        return guardaPersonaFicheroService.guardaEnFichero(persona);
    }
}
