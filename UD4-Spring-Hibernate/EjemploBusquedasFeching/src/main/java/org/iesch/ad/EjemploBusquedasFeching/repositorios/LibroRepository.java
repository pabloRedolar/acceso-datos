package org.iesch.ad.EjemploBusquedasFeching.repositorios;

import org.iesch.ad.EjemploBusquedasFeching.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer> {

}
