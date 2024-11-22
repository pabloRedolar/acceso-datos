package org.iesch.ad.EjemploBusquedasFeching;

import org.iesch.ad.EjemploBusquedasFeching.servicios.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EjemploBusquedasFechingApplication implements CommandLineRunner {
	@Autowired
	DataService dataService;

	public static void main(String[] args) {
		SpringApplication.run(EjemploBusquedasFechingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		dataService.crearDatos();
		dataService.testLazy();
	}
}
