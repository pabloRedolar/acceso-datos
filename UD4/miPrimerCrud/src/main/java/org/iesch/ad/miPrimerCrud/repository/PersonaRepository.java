package org.iesch.ad.miPrimerCrud.repository;

import org.iesch.ad.miPrimerCrud.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
    public List<Persona> findByCiudad (String ciudad);

    public List<Persona> findByCiudadOrDireccion (String ciudad, String direccion);

    @Query ("select p from Persona p where ciudad = ?1 and email =?2")
    public List<Persona> buscarPorCiudadYEmail (String ciudad, String email);
}
