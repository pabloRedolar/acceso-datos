package org.iesch.ad.crudpersonas.repositories;

import org.iesch.ad.crudpersonas.models.Persona;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends MongoRepository<Persona, Long> {

}
