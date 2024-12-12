package org.iesch.ad.ProyectoRepasoFinal.repositories;

import org.iesch.ad.ProyectoRepasoFinal.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("SELECT c FROM Cliente c where size(c.pedidos) > 1")
    List<Cliente> getClientesConPedido();


}
