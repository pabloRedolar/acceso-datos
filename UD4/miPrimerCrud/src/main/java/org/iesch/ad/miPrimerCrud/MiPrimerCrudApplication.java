package org.iesch.ad.miPrimerCrud;

import org.iesch.ad.miPrimerCrud.model.Persona;
import org.iesch.ad.miPrimerCrud.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
		persona1.setNombre("Pablo vicente");
		persona1.setApellido("Redolar");
		persona1.setDni("18456278C");
		persona1.setCiudad("Teruel");
		persona1.setEmail("pablo@gmail.com");
		persona1.setTelefono("659981050");
		persona1.setDireccion("Calle urbanizacion plano, alto");

		Persona persona2 = new Persona();
		persona2.setNombre("Juan jose");
		persona2.setApellido("Vicente");
		persona2.setDni("18453258C");
		persona2.setCiudad("Teruel");
		persona2.setEmail("juan@gmail.com");
		persona2.setTelefono("659981050");
		persona2.setDireccion("Telepi");

		Persona persona3 = new Persona();
		persona3.setNombre("Manuel angel");
		persona3.setApellido("Donate");
		persona3.setDni("18456278C");
		persona3.setCiudad("Teruel");
		persona3.setEmail("manuel@gmail.com");
		persona3.setTelefono("659586050");
		persona3.setDireccion("Calle urbanizacion plano");

		Persona persona4 = new Persona();
		persona4.setNombre("Remon marcos");
		persona4.setApellido("Rodriguez");
		persona4.setDni("18452268C");
		persona4.setCiudad("Teruel");
		persona4.setEmail("remon@gmail.com");
		persona4.setTelefono("659985052");
		persona4.setDireccion("Calle urbanizacion plano alto");


//		personaRepository.save(persona1);
//		personaRepository.save(persona2);
//		personaRepository.save(persona3);
//		personaRepository.save(persona4);


//		List<Persona> list = new ArrayList<>(Arrays.asList(persona1, persona2, persona3, persona4));

//		personaRepository.saveAll(list);

 		//Select * from ...
//		List<Persona> list = personaRepository.findAll();
//		list.forEach(System.out::println);


		//Select by id

		System.out.println("---------------------------------------------------------------");
//		Optional<Persona> persona = personaRepository.findById(5L);
//		System.out.println(persona.get());
//
//		Persona person = personaRepository.findById(51L).orElse(null);
//		System.out.println(person);

		System.out.println("\n-----------------------------------------------------------------\n");

		// Update

//		Optional<Persona> personaUpdated = personaRepository.findById(5L);
//
//		personaUpdated.get().setDni("18456345A");
//		personaUpdated.get().setDireccion("calle 1");
//		personaUpdated.get().setCiudad("Barcelona");
//		personaUpdated.get().setTelefono("60600600");
//		personaUpdated.get().setEmail("email@email.com");
//
//		personaRepository.save(personaUpdated.get());
//
//		Persona persona5 = new Persona();
//		persona5.setId(1L);
//		persona5.setNombre("Pepe");
//		personaRepository.save(persona5);



		System.out.println("\n-----------------------------------------------------------------\n");

		//Delete

		//personaRepository.deleteById(1L);
//		Persona persona6 = new Persona();
//		persona6.setId(2L);
//		personaRepository.delete(persona6);

		// Mas eficiente al tener una base muy grande
//		personaRepository.deleteAllInBatch();

		List<Persona> list = personaRepository.findByCiudadOrDireccion("Teruel", "Telepi");
		list.forEach(System.out::println);

		List<Persona> listMio = personaRepository.buscarPorCiudadYEmail("Teruel", "pablo@gmail.com");
		listMio.forEach(System.out::println);


		System.exit(1);
	}
}
