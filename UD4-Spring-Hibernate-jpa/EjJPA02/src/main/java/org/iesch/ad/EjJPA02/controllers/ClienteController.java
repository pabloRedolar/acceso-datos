package org.iesch.ad.EjJPA02.controllers;

import org.iesch.ad.EjJPA02.services.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
//    @Autowired
    ClienteService clienteService;
//
//    @GetMapping("/clientes")
//    public ResponseEntity<?> getClientes(){
//        return ResponseEntity.ok(clienteService.getClientesConDatos());
//    }
//
//    @GetMapping("/clientes/getCliente")
//    public ResponseEntity<?> getCliente(@RequestParam Long id){
//        return ResponseEntity.ok(clienteService.getOne(id));
//    }

//    @GetMapping("/cliente/por-color")
//    public ResponseEntity<?> getClientesColorCoche(@RequestParam String colorCoche) {
//        return ResponseEntity.ok(clienteService.findByCochesColor(colorCoche));
//    }

//    @GetMapping("/cliente/por-precio")
//    public ResponseEntity<?> getClientesConCochePrecioMayor(@RequestParam Double precio) {
//        return ResponseEntity.ok(clienteService.findClientesCochePrecioMayorA(precio));
//    }

    @GetMapping("/clientes/mas-coches-DTO")
    public ResponseEntity<?> getClienteMasCochesDTO() {
        return ResponseEntity.ok(clienteService.getClientesConMasCochesDTO());
    }
}
