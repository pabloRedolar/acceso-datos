package org.iesch.ad.Ej2.repositories;

import org.iesch.ad.Ej2.models.Raqueta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RaquetaRepository extends JpaRepository<Raqueta, Long> {

    List<Raqueta> findAllByMarca(String marca);

    @Query("select rep from Raqueta r join r.representante rep where r.id = :id")
    Object sacarRepresentantePorIdRaqueta(Long id);

}
