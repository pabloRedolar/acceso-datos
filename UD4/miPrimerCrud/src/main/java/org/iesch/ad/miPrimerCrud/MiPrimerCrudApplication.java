package org.iesch.ad.miPrimerCrud;

import org.iesch.ad.miPrimerCrud.model.Persona;
import org.iesch.ad.miPrimerCrud.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MiPrimerCrudApplication implements CommandLineRunner {
	@Autowired
	PersonaRepository personaRepository;

	public static void main(String[] args) {
		SpringApplication.run(MiPrimerCrudApplication.class, args);

	}

	@Override
	public void run(String... args) {
		System.out.println("Hola");
		Persona persona1 = new Persona();
		persona1.setNombre("Pablo");
		persona1.setApellido("Redolar");

		personaRepository.save(persona1);
	}
}
