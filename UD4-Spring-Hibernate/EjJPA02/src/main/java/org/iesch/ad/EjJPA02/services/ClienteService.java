package org.iesch.ad.EjJPA02.services;

import org.iesch.ad.EjJPA02.models.Cliente;
import org.iesch.ad.EjJPA02.repositories.ClienteRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteRespository clienteRespository;

//    @GetMapping("/clientes")
//    public List<Cliente> getClientesConDatos() {
//        return clienteRespository.findAll();
//    }
//
//    public Cliente getOne(Long id) {
////        return clienteRespository.findById(id).orElse(null);
//        return clienteRespository.findByIdMejor(id);
//    }

//    public List<Cliente> findByCochesColor(String colorCoche) {
//// Consulta named query
//        //        return clienteRespository.findByCocheColor(colorCoche);
//        return clienteRespository.BuscarDiscinctByCocheColor(colorCoche);
//    }

    public List<Cliente> findClientesCochePrecioMayorA(Double precio) {
        return clienteRespository.findClientesByCochesPrecioGreaterThan(precio);
    }
}
