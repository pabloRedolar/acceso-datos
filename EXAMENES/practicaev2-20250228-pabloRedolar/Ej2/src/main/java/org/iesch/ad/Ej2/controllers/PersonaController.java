package org.iesch.ad.Ej2.controllers;

import org.iesch.ad.Ej2.models.Persona;
import org.iesch.ad.Ej2.services.PersonasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonaController {

    @Autowired
    PersonasService personasService;


    @GetMapping("/personas")
    public ResponseEntity<?> personas() {

        return ResponseEntity.ok(personasService.personas());
    }

    @GetMapping("/personas/{id}")
    public ResponseEntity<?> personasPorId(@PathVariable String id) {
        return ResponseEntity.ok(personasService.personasPorId(id));
    }

    @PostMapping("/personas")
    public ResponseEntity<?> annadirPerson(@RequestBody Persona persona) {
        return ResponseEntity.status(HttpStatus.OK).body(personasService.annadirPersonas(persona));
    }

    @PutMapping("/personas/{id}")
    public ResponseEntity<?> actualizarPersonaPorId(@PathVariable String id, @RequestBody Persona persona) {
        return ResponseEntity.ok(personasService.actualizarPersonaPorId(id, persona));
    }

    @DeleteMapping("/personas/{id}")
    public ResponseEntity<?> borrarPersona(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(personasService.borrarPersona(id));
    }

    @GetMapping("/personas/{id}/vehiculos")
    public ResponseEntity<?> vehiculosPersonaPorId(@PathVariable String id) {
        return ResponseEntity.ok(personasService.vehiculosPersonaPorId(id));
    }

//    @PostMapping("/personas/{id}/vehiculos")
//    public ResponseEntity<?>
 }
