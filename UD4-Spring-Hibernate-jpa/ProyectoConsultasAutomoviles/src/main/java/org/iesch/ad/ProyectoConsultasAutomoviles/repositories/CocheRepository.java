package org.iesch.ad.ProyectoConsultasAutomoviles.repositories;

import org.iesch.ad.ProyectoConsultasAutomoviles.model.Coche;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;


public interface CocheRepository extends JpaRepository<Coche, String> {

    Set<Coche> findCochesByColor(String color);
}
