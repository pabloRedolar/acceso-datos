package org.iesch.ad.Ejercicios02.ej2EmpresaAutomoviles.repository;

import org.iesch.ad.Ejercicios02.ej2EmpresaAutomoviles.model.Cliente;
import org.iesch.ad.Ejercicios02.ej2EmpresaAutomoviles.model.Revision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
