package org.iesch.ad.ProyectoRepasoFinal.services;

import org.iesch.ad.ProyectoRepasoFinal.model.Cliente;
import org.iesch.ad.ProyectoRepasoFinal.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    public List<Cliente> getClientesConPedido() {
        return clienteRepository.getClientesConPedido();
//        return clienteRepository.findAll();
    }
}
