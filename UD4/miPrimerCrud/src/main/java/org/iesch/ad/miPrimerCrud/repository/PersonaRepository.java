package org.iesch.ad.miPrimerCrud.repository;

import org.iesch.ad.miPrimerCrud.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

}
