package org.iesch.ad.ProyectoConsultasAutomoviles.repositories;

import org.iesch.ad.ProyectoConsultasAutomoviles.model.Cliente;
import org.iesch.ad.ProyectoConsultasAutomoviles.model.Coche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    boolean existsClienteByNif(String nif);

    List<Cliente> findClienteByNombreAndApellidos(String nombre, String apellidos);

    Cliente getClienteById(Long id);

    List<Cliente> findDistinctByCochesColor(String color);
}
