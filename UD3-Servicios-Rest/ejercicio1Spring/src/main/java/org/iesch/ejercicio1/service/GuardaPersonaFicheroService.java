package org.iesch.ejercicio1.service;

import org.iesch.ejercicio1.model.Persona;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class GuardaPersonaFicheroService {
    private final String NOMBREFICHERO = "persona.txt";

    public Persona guardaEnFichero(Persona persona){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOMBREFICHERO))) {
            writer.write(persona.toString());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return persona;
    }
}
