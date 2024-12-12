package org.iesch.ad.ProyectoRepasoFinal.controllers;

import org.iesch.ad.ProyectoRepasoFinal.repositories.PedidoRepository;
import org.iesch.ad.ProyectoRepasoFinal.services.ClienteService;
import org.iesch.ad.ProyectoRepasoFinal.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/clientesConPedido")
    public ResponseEntity<?> getClientesConPedido() {
        return ResponseEntity.ok(clienteService.getClientesConPedido());
    }

    @GetMapping("/pedidoMasCaroCliente")
    public ResponseEntity<?> getPedidosMasCarosCliente() {
        return ResponseEntity.ok(pedidoService.pedidoMasCaroCliente());
    }


}
