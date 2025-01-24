package org.iesch.ad.CRUD_Mongo.services;

import org.iesch.ad.CRUD_Mongo.models.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaUsingTemplateService {
    @Autowired
    MongoTemplate mongoTemplate;

    public List<Persona> getAll() {
        return mongoTemplate.findAll(Persona.class);
    }

    public Object subirUno(Persona persona) {
        return mongoTemplate.save(persona);

    }

    public Persona buscarPersona(String id) {
        return mongoTemplate.findById(id, Persona.class);
    }

    public Persona updatePersona(Persona persona) {
        return mongoTemplate.save(persona);
    }

    public void deletePersona(Persona persona) {
       mongoTemplate.remove(persona);
    }
}
