package org.iesch.ad.Ejer.prueba._ev.repositories;

import org.iesch.ad.Ejer.prueba._ev.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioProducto extends JpaRepository<Producto, Long> {

}
