package org.iesch.ad.EjemploBusquedasFeching.repositorios;

import org.iesch.ad.EjemploBusquedasFeching.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer> {

}
