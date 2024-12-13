package org.iesch.ad.ProyectoConsultasAutomoviles.controllers;

import org.iesch.ad.ProyectoConsultasAutomoviles.model.DTO.ClienteDTO;
import org.iesch.ad.ProyectoConsultasAutomoviles.repositories.ClienteRepository;
import org.iesch.ad.ProyectoConsultasAutomoviles.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")

public class ClienteController {
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ClienteRepository clienteRepository;


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

    // ********************************** Ejercicios consultas ***************************************

    @GetMapping("/clientesCocheColor")
    public ResponseEntity<?> getClientesCochesColor(@RequestParam String color) {
        return ResponseEntity.ok(clienteService.getClientesCochesPorColor(color));
    }

    @GetMapping("/por-precio")
    public ResponseEntity<?> getClientesCochePrecioMayorX(@RequestParam Float precio) {
        return ResponseEntity.ok(clienteService.getClientesCochePrecioMayorX(precio));
    }

    @GetMapping("mas-coches")
    public ResponseEntity<?> getAtributosClienteConMasCoches() {
        return ResponseEntity.ok(clienteService.getAtributosClienteConMasCoches());
    }

//    @GetMapping("mas-coches")
//    public ResponseEntity<?> getAtributosClienteConMasCoches() {
//        return ResponseEntity.ok(clienteService.getAtributosClienteConMasCoches());
//    }

    @GetMapping("/por-matricula")
    public ResponseEntity<?> getClientePorMatricula(@RequestParam String matricula) {
        return ResponseEntity.ok(clienteService.getClientePorMatricula(matricula));
    }

    @GetMapping("/codigo-por-matricula")
    public ResponseEntity<?> getClientePorCodigoRevision(@RequestParam String codigoInterno) {
        return ResponseEntity.ok(clienteService.getClientePorCodigoRevision(codigoInterno));
    }

    @GetMapping("/por-codigo-revision-detalles")
    public ResponseEntity<?> getClienteSinCochesPorCodigoRevision(@RequestParam String codigo) {
        return ResponseEntity.ok(clienteService.getClienteSinCochesPorCodigoRevision(codigo));

    }


    @GetMapping("/a1")
    public ResponseEntity<?> a1() {
        return ResponseEntity.ok(clienteRepository.findClientesByCochesIsEmpty());
    }

    @GetMapping("/a2")
    public ResponseEntity<?> a2() {
        return ResponseEntity.ok(clienteRepository.cochesSinRevision());
    }

    @GetMapping("/a3")
    public ResponseEntity<?> a3() {
        return ResponseEntity.ok(clienteRepository.cocheMasCaro());
    }

    @GetMapping("/a4")
    public ResponseEntity<?> a4() {
        return ResponseEntity.ok(clienteRepository.cocheConRevisiones());
    }


}
