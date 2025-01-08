package org.iesch.ad.Ejer.prueba._ev.repositories;

import org.iesch.ad.Ejer.prueba._ev.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface RepositorioCategoria extends JpaRepository<Categoria, Long> {

}
