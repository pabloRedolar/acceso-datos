package org.iesch.ad.ProyectoConsultasAutomoviles.repositories;

import org.iesch.ad.ProyectoConsultasAutomoviles.model.Cliente;
import org.iesch.ad.ProyectoConsultasAutomoviles.model.DTO.ClienteDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {


    boolean existsClienteByNif(String nif);

    List<Cliente> findClienteByNombreAndApellidos(String nombre, String apellidos);

    Cliente getClienteById(Long id);

    List<Cliente> findDistinctByCochesColor(String color);

    List<Cliente> findClientesByCochesPrecioGreaterThan(Float precio);

//    @Query("SELECT c " +
//            "FROM Cliente c " +
//            "JOIN c.coches co " +
//            "GROUP BY c.nif, c.nombre, c.ciudad " +
//            "having count(co) = (SELECT MAX(count(co2)) from Cliente c1 JOIN c1.coches co2 group by c1)")

    @Query("SELECT new org.iesch.ad.ProyectoConsultasAutomoviles.model.DTO.ClienteDTO(c.nif, c.nombre, c.ciudad) " +
            "FROM Cliente c WHERE SIZE(c.coches) = (SELECT MAX(SIZE(cli.coches)) FROM Cliente cli)")

    List<ClienteDTO> getClientesConMasCoches();
}
