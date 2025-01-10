package org.iesch.ad.Ej2.controllers;

import org.iesch.ad.Ej2.models.Tenista;
import org.iesch.ad.Ej2.repositories.TenistaRepository;
import org.iesch.ad.Ej2.services.TenistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class TenistaController {
    @Autowired
    TenistaService tenistaService;

    @GetMapping("/tenistas")
    public ResponseEntity<?> getTenistas() {
        return ResponseEntity.ok(tenistaService.getTenistas());
    }

    @GetMapping("/tenistas/{id}")
    public ResponseEntity<?> getTenistasPorId(@PathVariable Long id){
        return ResponseEntity.ok(tenistaService.getTenistasPorId(id));
    }

    @PostMapping("/tenista")
    public ResponseEntity<?> postTenista(@RequestBody List<Tenista> tenistas) {
        return ResponseEntity.ok(tenistaService.postTenista(tenistas));
    }

    @PutMapping("/tenistas/{id}")
    public ResponseEntity<?> putTenistaPorId(@PathVariable Long id, @RequestBody Tenista tenista) {
        return ResponseEntity.ok(tenistaService.putTenistaPorId(id, tenista));
    }

    @DeleteMapping("/tenistas/{id}")
    public ResponseEntity<?> deleteTenistaById(@PathVariable Long id) {
        return ResponseEntity.ok(tenistaService.deleteTenistaById(id));
    }

    // Resto de gets
}
