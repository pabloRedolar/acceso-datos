package org.iesch.ad.Ejercicios02.ej2EmpresaAutomoviles.repository;

import org.iesch.ad.Ejercicios02.ej2EmpresaAutomoviles.model.Coche;
import org.iesch.ad.Ejercicios02.ej2EmpresaAutomoviles.model.Revision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevisionRepository extends JpaRepository<Revision, Long> {

}
