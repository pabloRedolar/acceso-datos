package org.iesch.ad.ProyectoConsultasAutomoviles.controllers;

import org.iesch.ad.ProyectoConsultasAutomoviles.model.DTO.ClienteDTO;
import org.iesch.ad.ProyectoConsultasAutomoviles.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/cliente")
@RestController
public class ClienteController {
    @Autowired
    private ClienteService clienteService;


    @PostMapping("/crearUsuario")
    public ResponseEntity<?> crearUsuario(@RequestBody ClienteDTO clienteDTO) {
        return ResponseEntity.ok(clienteService.crearUsuario(clienteDTO));
    }

    @GetMapping("/buscarUsuario")
    public ResponseEntity<?> buscarUsuario(@RequestParam String nombre, @RequestParam String apellidos) {
        return ResponseEntity.ok(clienteService.buscarUsuario(nombre, apellidos));
    }

    @PutMapping("/actualizarUsuario")
    public ResponseEntity<?> actualizarUsuarioPorNombreApellidos(@RequestParam Long id, @RequestBody ClienteDTO clienteDTO) {
        return ResponseEntity.ok(clienteService.actualizarUsuario(id, clienteDTO));
    }

    @DeleteMapping("/borrarPorId")
    public ResponseEntity<?> borrarClientePorId(@RequestParam Long id) {
        return ResponseEntity.ok(clienteService.borrarCliente(id));
    }


    @GetMapping("/clientesCocheColor")
    public ResponseEntity<?> getClientesCochesColor(@RequestParam String color) {
        return ResponseEntity.ok(clienteService.getClientesCochesPorColor(color));
    }
}
