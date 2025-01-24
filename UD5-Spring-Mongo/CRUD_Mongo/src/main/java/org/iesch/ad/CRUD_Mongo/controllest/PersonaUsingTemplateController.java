package org.iesch.ad.CRUD_Mongo.controllest;

import org.iesch.ad.CRUD_Mongo.models.Persona;
import org.iesch.ad.CRUD_Mongo.services.PersonaUsingTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonaUsingTemplateController {
    @Autowired
    PersonaUsingTemplateService personaUsingTemplateService;

    @GetMapping("/personaT")
    public ResponseEntity<?> responseGetTodos() {
        List<Persona> personas = personaUsingTemplateService.getAll();

        if (personas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(personas);
    }

    @PostMapping("/personaT")
    public ResponseEntity<?> subirUno(@RequestBody Persona persona) {
        personaUsingTemplateService.subirUno(persona);
        return ResponseEntity.ok(persona);
    }

    @GetMapping("/personaT/{id}")
    public ResponseEntity<?> buscarPersona(@PathVariable String id){

        return ResponseEntity.ok(personaUsingTemplateService.buscarPersona(id));
    }

    @PutMapping("personaT/{id}")
    public ResponseEntity<?> editarPersona(@PathVariable String id, @RequestBody Persona persona){
        Persona persona1 = personaUsingTemplateService.buscarPersona(id);

        if (persona1 == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(persona1);
    }

    @DeleteMapping("personaT/{id}")
    public ResponseEntity<?> deletePersona(@PathVariable String id) {
        Persona persona = personaUsingTemplateService.buscarPersona(id);
        personaUsingTemplateService.deletePersona(persona);
        return ResponseEntity.noContent().build();
    }

}
