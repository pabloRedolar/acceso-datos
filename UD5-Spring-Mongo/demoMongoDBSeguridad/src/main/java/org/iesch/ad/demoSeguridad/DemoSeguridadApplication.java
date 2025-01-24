package org.iesch.ad.demoSeguridad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DemoSeguridadApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSeguridadApplication.class, args);
	}

}
