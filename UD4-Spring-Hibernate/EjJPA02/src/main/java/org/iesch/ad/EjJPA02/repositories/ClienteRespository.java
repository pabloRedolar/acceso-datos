package org.iesch.ad.EjJPA02.repositories;

import org.iesch.ad.EjJPA02.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRespository extends JpaRepository<Cliente, Long> {

    @Query("SELECT c FROM cliente c, revision r JOIN FETCH c.coches coch JOIN FETCH co.revisiones WHERE c.id = :id")
    Cliente findByIdMejor(Long id);
}
