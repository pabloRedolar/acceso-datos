package org.iesch.ad.Ej2.repositories;

import org.iesch.ad.Ej2.models.Representante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepresentanteRepository extends JpaRepository<Representante, Long> {

    Object findByNombre(String nombre);
}
