package org.iesch.ad.ProyectoRepasoFinal.services;

import org.iesch.ad.ProyectoRepasoFinal.model.Pedido;
import org.iesch.ad.ProyectoRepasoFinal.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    @Autowired
    PedidoRepository pedidoRepository;

    public List<Object> pedidoMasCaroCliente() {
        return pedidoRepository.pedidoMasCaroCliente();
    }
}
