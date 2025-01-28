package org.iesch.ad.crudpersonas.controllers;

import org.iesch.ad.crudpersonas.models.Persona;
import org.iesch.ad.crudpersonas.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    PersonaRepository personaRepository;

    @PostMapping("/crear")
    public ResponseEntity<?> crearPersona(@RequestBody List<Persona> personas) {
        return ResponseEntity.ok(personaRepository.saveAll(personas));
    }

    @GetMapping("/buscar")
    public ResponseEntity<?> buscarPersonaMayorXedad(@RequestParam int edad, @RequestParam String ciudad) {
        return ResponseEntity.ok(personaRepository.findPersonaByEdadGreaterThanAndCiudad(edad, ciudad));

    }

    @GetMapping("/buscarPorNombreApellido")
    public ResponseEntity<?> buscarPorNombreApellido(@RequestParam String nombre, @RequestParam String apellido) {
        return ResponseEntity.ok(personaRepository.findPersonasByNombreOrApellido(nombre, apellido));
    }

    @GetMapping("/buscarRangoEdadYcalleXXX")
    public ResponseEntity<?> buscarRangoEdadYcalleXXX(@RequestParam int edadMinima, @RequestParam int edadMaxima, @RequestParam String calle, @RequestParam String numero) {
        return ResponseEntity.ok(personaRepository.findPersonasByEdadBetweenAndDireccion_CalleAndDireccion_Numero(edadMinima, edadMaxima, calle, numero));

    }
}
