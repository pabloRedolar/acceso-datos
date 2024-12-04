package org.iesch.ad.EjJPA02.repositories;

import org.iesch.ad.EjJPA02.models.Coche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CocheRepository extends JpaRepository<Coche, String> {

    List<Coche> findTopByOrderByRevisionesAsc();
}
