package org.iesch.ad.demoMongo_Spring;

import org.iesch.ad.demoMongo_Spring.models.Trabajador;
import org.iesch.ad.demoMongo_Spring.repositories.TrabajadorRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class DemoMongoSpringApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoMongoSpringApplication.class, args);

		var repo = context.getBean(TrabajadorRepo.class);

		List<Trabajador> trabajadores = List.of(
				new Trabajador(null, "Manuel", "Julve", "manuel@iesch.org", LocalDate.of(2005, 3, 12)),
				new Trabajador(null, "Juan", "Julve", "juan@iesch.org", LocalDate.of(2008, 3, 3)),
				new Trabajador(null, "Rremon", "Julve", "remon@iesch.org", LocalDate.of(2007, 3, 23)),
				new Trabajador(null, "Toni", "Julve", "toni@iesch.org", LocalDate.of(2006, 3, 28))
		);

		repo.saveAll(trabajadores);
		repo.findAll().forEach(System.out::println);
	}
}
