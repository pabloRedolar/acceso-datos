package org.iesch.ad.Ejercicios02.ej2EmpresaAutomoviles.services;

import jakarta.transaction.Transactional;
import org.iesch.ad.Ejercicios02.ej2EmpresaAutomoviles.model.Cliente;
import org.iesch.ad.Ejercicios02.ej2EmpresaAutomoviles.model.ClienteDTO;
import org.iesch.ad.Ejercicios02.ej2EmpresaAutomoviles.model.CocheDTO;
import org.iesch.ad.Ejercicios02.ej2EmpresaAutomoviles.repository.ClienteRepository;
import org.iesch.ad.Ejercicios02.ej2EmpresaAutomoviles.repository.CocheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;
    CocheRepository cocheRepository;

    @Transactional
    public Object getAll() {
        List<Cliente> clientes= clienteRepository.findAll();
        List<ClienteDTO> clienteDTOS = new ArrayList<>();

        clientes.forEach(cliente -> {
            ClienteDTO clienteDTO = new ClienteDTO();
            clienteDTO.setId(cliente.getId());
            clienteDTO.setNif(cliente.getNif());
            clienteDTO.setNombre(cliente.getNif());
            clienteDTO.setApellidos(cliente.getApellidos());
            clienteDTO.setTelefono(cliente.getTelefono());
            clienteDTO.setCiudad(cliente.getCiudad());
            clienteDTO.setDireccion(clienteDTO.getDireccion());

            List<CocheDTO> cocheDTOSet = cocheRepository.findByClienteId(cliente.getId()).stream().map(coche -> {
                CocheDTO cocheDTO = new CocheDTO();
                cocheDTO.setMatricula(coche.getMatricula());
                cocheDTO.setMarca(coche.getMarca());
                return cocheDTO;

            }).toList();
            clienteDTO.setCochesDTO(cocheDTOSet);
            clienteDTOS.add(clienteDTO);

        });

        return clienteDTOS;
    }

    public Object getClientes() {
        return clienteRepository.findAll();
    }
}
