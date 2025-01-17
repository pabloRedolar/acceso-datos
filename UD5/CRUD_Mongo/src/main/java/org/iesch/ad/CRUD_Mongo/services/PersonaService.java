package org.iesch.ad.CRUD_Mongo.services;

import org.iesch.ad.CRUD_Mongo.models.Persona;
import org.iesch.ad.CRUD_Mongo.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {
    @Autowired
    PersonaRepository personaRepository;

    public List<Persona> getAll() {
        return personaRepository.findAll();
    }
}
