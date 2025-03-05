package org.iesch.ad.Ej2.controllers;

import org.iesch.ad.Ej2.models.Persona;
import org.iesch.ad.Ej2.models.Vehiculo;
import org.iesch.ad.Ej2.services.PersonasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonaController {

    @Autowired
    PersonasService personasService;


    //2.1
    @GetMapping("/personas")
    public ResponseEntity<?> personas() {

        return ResponseEntity.ok(personasService.personas());
    }

    //2.2
    @GetMapping("/personas/{id}")
    public ResponseEntity<?> personasPorId(@PathVariable String id) {
        return ResponseEntity.ok(personasService.personasPorId(id));
    }

    //2.3
    @PostMapping("/personas")
    public ResponseEntity<?> annadirPerson(@RequestBody Persona persona) {
        return ResponseEntity.status(HttpStatus.OK).body(personasService.annadirPersonas(persona));
    }

    //2.4
    @PutMapping("/personas/{id}")
    public ResponseEntity<?> actualizarPersonaPorId(@PathVariable String id, @RequestBody Persona persona) {
        return ResponseEntity.ok(personasService.actualizarPersonaPorId(id, persona));
    }

    //2.5
    @DeleteMapping("/personas/{id}")
    public ResponseEntity<?> borrarPersona(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(personasService.borrarPersona(id));
    }

    //2.6
    @GetMapping("/personas/{id}/vehiculos")
    public ResponseEntity<?> vehiculosPersonaPorId(@PathVariable String id) {
        return ResponseEntity.ok(personasService.vehiculosPersonaPorId(id));
    }

    //2.7

    //Preguntar a la IA si esto debe ser un post o un put
    @PostMapping("/personas/{id}/vehiculos")
    public ResponseEntity<?> crearVehiculoPersonaPorId(@PathVariable String id, @RequestBody Vehiculo vehiculo) {

        return ResponseEntity.ok(personasService.crearVehiculoPersonaPorId(id, vehiculo));
    }
}