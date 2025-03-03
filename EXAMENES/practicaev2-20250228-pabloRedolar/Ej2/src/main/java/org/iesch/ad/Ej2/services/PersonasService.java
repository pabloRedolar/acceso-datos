package org.iesch.ad.Ej2.services;

import org.iesch.ad.Ej2.models.Persona;
import org.iesch.ad.Ej2.models.Vehiculo;
import org.iesch.ad.Ej2.repos.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@Service
public class PersonasService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private PersonaRepository personaRepository;

    public Object personas() {
        return mongoTemplate.findAll(Persona.class);
    }

    public Object personasPorId(String id) {
        return mongoTemplate.findById(id, Persona.class);
    }

    public Object annadirPersonas(Persona persona) {
        return mongoTemplate.save(persona);
    }

    public Object actualizarPersonaPorId(String id, Persona persona) {

        if (mongoTemplate.exists(Query.query(Criteria.where("id").is(id)), Persona.class)) {
            persona.setId(id);
            return mongoTemplate.save(persona);

        } return false;

    }

    public Object borrarPersona(String id) {
        return mongoTemplate.findAndRemove(Query.query(Criteria.where("id").is(id)), Persona.class);
    }

    public Object vehiculosPersonaPorId(String id) {

        return mongoTemplate.find(Query.query(Criteria.where("id").is(id)), Vehiculo.class);
    }
}
