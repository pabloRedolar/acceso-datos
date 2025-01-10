package org.iesch.ad.Ej2.controllers;

import org.iesch.ad.Ej2.models.Raqueta;
import org.iesch.ad.Ej2.models.Representante;
import org.iesch.ad.Ej2.services.RaquetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RaquetaController {
    @Autowired
    RaquetaService raquetaService;

    @GetMapping("/raquetas")
    public ResponseEntity<?> getRaquetas() {
        return ResponseEntity.ok(raquetaService.getRaquetas());
    }

    @GetMapping("/raquetas/{id}")
    public ResponseEntity<?> getRaquetasPorId(@PathVariable Long id) {
        return ResponseEntity.ok(raquetaService.getRaquetasPorId(id));
    }

    @PostMapping("/raquetas")
    public ResponseEntity<?> postRaquetas(@RequestBody List<Raqueta> raquetas) {
        return ResponseEntity.ok(raquetaService.postRaquetas(raquetas));
    }

    @PutMapping("/raquetas/{id}")
    public ResponseEntity<?> putRaquetas(@PathVariable Long id, @RequestBody Raqueta raqueta) {
        return ResponseEntity.ok(raquetaService.putRaquetas(id, raqueta));
    }

    @DeleteMapping("/raquetas/{id}")
    public ResponseEntity<?> deleteRaquetas(@PathVariable Long id) {
        return ResponseEntity.ok(raquetaService.deleteRaquetas(id));
    }

    @GetMapping("/raquetas/find")
    public ResponseEntity<?> findRaquetaPorMarca (@RequestParam String marca) {
        return ResponseEntity.ok(raquetaService.findRaquetaPorMarca(marca));
    }

    @GetMapping("/raquetas/{id}/representante")
    public ResponseEntity<?> getRepresentanteDeRaquetaPorId (@PathVariable Long id) {
            return ResponseEntity.ok(raquetaService.getRepresentanteDeRaquetaPorId(id));
        }
    }
