package org.iesch.ad.Ej2.services;

import org.iesch.ad.Ej2.models.Persona;
import org.iesch.ad.Ej2.repos.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserEntityService {

    @Autowired
    PersonaRepository personaRepository;

    public Optional<Persona> findByUsername(String username){
        return personaRepository.findByUsername(username);
    }
}
