package org.iesch.ad.Ej2.controllers;

import org.iesch.ad.Ej2.models.Representante;
import org.iesch.ad.Ej2.services.RepresentanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RepresentanteController {
    @Autowired
    RepresentanteService representanteService;

    @GetMapping("/representantes")
    public ResponseEntity<?> getRepresentantes() {
        return ResponseEntity.ok(representanteService.getRepresentantes());
    }

    @GetMapping("/representantes/{id}")
    public ResponseEntity<?> getRepresentantePorId(@PathVariable Long id) {
        return ResponseEntity.ok(representanteService.getRepresentantePorId(id));
    }

    @PostMapping("/representantes")
    public ResponseEntity<?> postRepresentante(@RequestBody List<Representante> representantes) {
        return ResponseEntity.ok(representanteService.postRepresentante(representantes));
    }

    @PutMapping("/representantes/{id}")
    public ResponseEntity<?> putRepresentante(@PathVariable Long id, @RequestBody Representante representante) {
        return ResponseEntity.ok(representanteService.putRepresentante(id, representante));
    }

    @DeleteMapping("/representante/{id}")
    public ResponseEntity<?> deleteRepresentante(@PathVariable Long id) {
        return ResponseEntity.ok(representanteService.deleteRepresentante(id));
    }

    @GetMapping("/representantes/find")
    public ResponseEntity<?> getRepresentantesPorNombre (@RequestParam String nombre) {
        return ResponseEntity.ok(representanteService.getRepresentantesPorNombre(nombre));
    }

}
