package org.iesch.ad.ejerciciosmongo2.repositories;

import org.iesch.ad.ejerciciosmongo2.models.Persona;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PersonaRepository extends MongoRepository<Persona, String> {

    List<Persona> findPersonasByCiudad(String ciudad);

    List<Persona> findPersonasByNombreStartsWith(String nombre);

    List<Persona> findPersonasByEdadBetween(Integer edadAfter, Integer edadBefore);

    List<Persona> findPersonasByInteresesContains(String interes);

    @Query(value = "{apellido: ?0}")
    Object buscarPorApellidoUltimaLetra(String letra);
}
