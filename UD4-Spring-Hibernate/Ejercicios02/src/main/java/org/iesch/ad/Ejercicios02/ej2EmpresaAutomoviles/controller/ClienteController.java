package org.iesch.ad.Ejercicios02.ej2EmpresaAutomoviles.controller;

import org.iesch.ad.Ejercicios02.ej2EmpresaAutomoviles.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping("/SoloClientes")
    public ResponseEntity<?> getClientes() {
        return ResponseEntity.ok(clienteService.getClientes());
    }
}
