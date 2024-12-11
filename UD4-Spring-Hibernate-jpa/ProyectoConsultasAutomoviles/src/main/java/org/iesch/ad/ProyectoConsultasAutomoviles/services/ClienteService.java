package org.iesch.ad.ProyectoConsultasAutomoviles.services;

import org.iesch.ad.ProyectoConsultasAutomoviles.model.Cliente;
import org.iesch.ad.ProyectoConsultasAutomoviles.model.DTO.ClienteDTO;
import org.iesch.ad.ProyectoConsultasAutomoviles.repositories.ClienteRepository;
import org.iesch.ad.ProyectoConsultasAutomoviles.repositories.CocheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;


    public Boolean crearUsuario(ClienteDTO clienteDTO) {

        if (clienteRepository.existsClienteByNif(clienteDTO.getNif())) {
            return false;
        }

        Cliente cliente = new Cliente();

        cliente.setNombre(clienteDTO.getNombre());
//        cliente.setApellidos(clienteDTO.getApellidos());
        cliente.setCiudad(clienteDTO.getCiudad());
//        cliente.setDireccion(clienteDTO.getDireccion());
        cliente.setNif(clienteDTO.getNif());
//        cliente.setTelefono(clienteDTO.getTelefono());


        try {
            clienteRepository.save(cliente);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public Object buscarUsuario(String nombre, String apellidos) {
        return clienteRepository.findClienteByNombreAndApellidos(nombre, apellidos);
    }


    public Boolean borrarCliente(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);

        if (cliente != null) {
            clienteRepository.deleteById(id);
            return true;
        }
        return false;
    }


    public Cliente actualizarUsuario(Long id, ClienteDTO clienteDTO) {
        try {
            Cliente cliente = clienteRepository.getClienteById(id);

            cliente.setNif(clienteDTO.getNif());
            cliente.setNombre(clienteDTO.getNombre());
//            cliente.setApellidos(clienteDTO.getApellidos());
//            cliente.setTelefono(clienteDTO.getTelefono());
            cliente.setCiudad(clienteDTO.getCiudad());
//            cliente.setDireccion(clienteDTO.getDireccion());

            clienteRepository.save(cliente);
            return cliente;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Cliente> getClientesCochesPorColor(String color) {

        return clienteRepository.findDistinctByCochesColor(color);
    }

    public Object getClientesCochePrecioMayorX(Float precio) {
        List<Cliente> clientes = clienteRepository.findClientesByCochesPrecioGreaterThan(precio);

        return clientes;
    }

    public Object getAtributosClienteConMasCoches() {
        List<ClienteDTO> clientes = clienteRepository.getClientesConMasCoches();

//        List<ClienteDTO> clienteDTOS = new ArrayList<>();
//
//        for (Cliente cliente : clientes) {
//            ClienteDTO clienteDTO = new ClienteDTO();
//            clienteDTO.setNif(cliente.getNif());
//            clienteDTO.setNombre(cliente.getNombre());
//            clienteDTO.setCiudad(cliente.getCiudad());
//
//            clienteDTOS.add(clienteDTO);
//        }

        return clientes;
    }

    public ClienteDTO getClientePorMatricula(String matricula) {
        Cliente cliente = clienteRepository.getClientePorMatricula(matricula);

        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setNombre(cliente.getNombre());
        clienteDTO.setNif(cliente.getNif());
        clienteDTO.setApellidos(cliente.getApellidos());
        clienteDTO.setCiudad(cliente.getCiudad());
        clienteDTO.setDireccion(cliente.getDireccion());
        clienteDTO.setTelefono(cliente.getTelefono());

        return clienteDTO;
    }

    public Object getClientePorCodigoRevision(String codigoInterno) {
        Cliente cliente = clienteRepository.getClientePorCodigoRevision(codigoInterno);

        ClienteDTO clienteDTO = new ClienteDTO(
                cliente.getNif(),
                cliente.getNombre(),
                cliente.getApellidos(),
                cliente.getCiudad(),
                cliente.getDireccion(),
                cliente.getTelefono()
        );

        return clienteDTO;

    }
}
