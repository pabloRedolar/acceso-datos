package org.iesch.ad.Ejercicios02.ej2EmpresaAutomoviles.repository;

import org.iesch.ad.Ejercicios02.ej2EmpresaAutomoviles.model.Coche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CocheRepository extends JpaRepository<Coche, String> {

    public List<Coche> findByClienteId(Long id);

}
