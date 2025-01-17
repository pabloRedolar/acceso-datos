package org.iesch.ad.CRUD_Mongo.controllest;

import org.iesch.ad.CRUD_Mongo.models.Persona;
import org.iesch.ad.CRUD_Mongo.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonaController {
    @Autowired
    PersonaService personaService;

    @GetMapping("/persona")
    public ResponseEntity<?> responseGetTodos() {
        List<Persona> personas = personaService.getAll();

        if (personas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(personas);
    }

    @PostMapping("/persona")
    public ResponseEntity<?> subirUno() {


        return ResponseEntity.ok();
    }
}
