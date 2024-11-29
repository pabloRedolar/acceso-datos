package org.iesch.ad.EjJPA02.controllers;

import org.iesch.ad.EjJPA02.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping("/clientes")
    public ResponseEntity<?> getClientes(){
        return ResponseEntity.ok(clienteService.getClientesConDatos());
    }

    @GetMapping("/clientes/getCliente")
    public ResponseEntity<?> getCliente(@RequestParam Long id){
        return ResponseEntity.ok(clienteService.getOne(id));
    }

}
