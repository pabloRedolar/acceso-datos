package org.iesch.ad.crudpersonas.repositories;

import org.iesch.ad.crudpersonas.models.Persona;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends MongoRepository<Persona, Long> {

    List<Persona> findPersonaByEdadGreaterThanAndCiudad(int edad, String ciudad);

    List<Persona> findPersonasByNombreOrApellido(String nombre, String apellido);

    List<Persona> findPersonasByEdadBetweenAndDireccion_CalleAndDireccion_Numero(int edadMinima, int edadMaxima, String calle, String numero);
}
