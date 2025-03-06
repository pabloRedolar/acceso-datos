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
    @PostMapping("/personas/{id}/vehiculos")
    public ResponseEntity<?> crearVehiculoPersonaPorId(@PathVariable String id, @RequestBody Vehiculo vehiculo) {

        Persona persona = (Persona) personasService.crearVehiculoPersonaPorId(id, vehiculo);

        if (persona == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(persona);
        }

    }

    //2.8
    @DeleteMapping("/personas/{id}/vehiculos/{matricula}")
    public ResponseEntity<?> eliminarVechiculoDePersonaPorMatriculaId(@PathVariable String id, @PathVariable String matricula) {

        if (personasService.eliminarVechiculoDePersonaPorMatriculaId(id, matricula)) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    //2.9
    @GetMapping("/vehiculos/{matricula}/potencia-fiscal")
    public ResponseEntity<?> sacarPotenciaFiscal(@PathVariable String matricula) {

        return ResponseEntity.ok(personasService.sacarPotenciaFiscal(matricula));


    }



    // Hacer que el usuario solo pueda acceder a un endpoint si el jwt token es correcto
    @PostMapping("/jwt/personas")
    public ResponseEntity<?> annadirPersonJwt(@RequestBody Persona persona) {
        return ResponseEntity.status(HttpStatus.OK).body(personasService.annadirPersonas(persona));
    }

}