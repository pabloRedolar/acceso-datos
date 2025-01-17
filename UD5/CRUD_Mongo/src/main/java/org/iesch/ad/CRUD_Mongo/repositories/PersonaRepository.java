package org.iesch.ad.CRUD_Mongo.repositories;

import org.iesch.ad.CRUD_Mongo.models.Persona;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends MongoRepository<Persona, Long> {

}
