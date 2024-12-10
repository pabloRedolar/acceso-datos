//package org.iesch.ad.Ejercicios02.ej2EmpresaAutomoviles.controller;
//
//import org.iesch.ad.Ejercicios02.ej2EmpresaAutomoviles.services.CocheService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class CocheController {
//    @Autowired
//    CocheService cocheService;
//    @GetMapping("/coches")
//    public ResponseEntity<?> getAll(){
//        return ResponseEntity.ok(cocheService.getAll());
//    }
//
//    @GetMapping("/coches/{id}")
//    public ResponseEntity<?> getAllCoches(@PathVariable Long id){
//        return ResponseEntity.ok(cocheService.getAllById(id));
//    }
//}
