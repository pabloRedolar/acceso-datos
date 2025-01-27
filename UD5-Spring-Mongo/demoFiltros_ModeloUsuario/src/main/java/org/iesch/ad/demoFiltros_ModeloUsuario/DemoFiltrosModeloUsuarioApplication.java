package org.iesch.ad.demoFiltros_ModeloUsuario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing //Para q funcione la auditoria
public class DemoFiltrosModeloUsuarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoFiltrosModeloUsuarioApplication.class, args);
	}

}
