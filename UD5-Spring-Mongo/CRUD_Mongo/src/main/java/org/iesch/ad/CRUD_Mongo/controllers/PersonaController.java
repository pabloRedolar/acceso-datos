//package org.iesch.ad.CRUD_Mongo.controllest;
//
//import org.iesch.ad.CRUD_Mongo.models.Persona;
//import org.iesch.ad.CRUD_Mongo.services.PersonaService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//public class PersonaController {
//    @Autowired
//    PersonaService personaService;
//
//    @GetMapping("/persona")
//    public ResponseEntity<?> responseGetTodos() {
//        List<Persona> personas = personaService.getAll();
//
//        if (personas.isEmpty()) {
//            return ResponseEntity.noContent().build();
//        }
//        return ResponseEntity.ok(personas);
//    }
//
//    @PostMapping("/persona")
//    public ResponseEntity<?> subirUno(@RequestBody Persona persona) {
//        return ResponseEntity.ok(personaService.subirUno(persona));
//
//    }
//
//    @GetMapping("/persona/{id}")
//    public ResponseEntity<?> buscarPersona(@PathVariable Long id){
//
//        return ResponseEntity.ok(personaService.buscarPersona(id));
//    }
//
//    @PutMapping("persona/{id}")
//    public ResponseEntity<?> editarPersona(@PathVariable String id, @RequestBody Persona persona){
//        Persona persona1 = personaService.getPersonaPorId(persona);
//
//        if (persona == null){
//            return ResponseEntity.noContent().build();
//        }
//        return ResponseEntity.ok(persona1);
//    }
//
//
//    @DeleteMapping("persona/{id}")
//    public ResponseEntity<?> deletePersona(@PathVariable String id) {
//        Persona persona1;
//        return ResponseEntity.noContent().build();
//    }
//
//}
