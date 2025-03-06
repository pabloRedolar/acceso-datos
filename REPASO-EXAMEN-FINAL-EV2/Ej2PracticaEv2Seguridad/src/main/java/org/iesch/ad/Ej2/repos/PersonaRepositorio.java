package org.iesch.ad.Ej2.repos;

import org.iesch.ad.Ej2.models.Persona;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonaRepositorio extends MongoRepository<Persona, String> {
    Optional<Persona> findByNombre(String nombre);
}
