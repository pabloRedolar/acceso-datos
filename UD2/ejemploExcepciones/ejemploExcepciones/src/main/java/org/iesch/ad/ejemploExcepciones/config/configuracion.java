package org.iesch.ad.ejemploExcepciones.config;

import org.iesch.ad.ejemploExcepciones.model.Usuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class configuracion {
    @Bean
    List<Usuario> usuarioList() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(Usuario.builder().id(1).nombre("Juan").apellidos("Perez Perez").build());
        usuarios.add(Usuario.builder().id(2).nombre("Pepe").apellidos("Leon Martinez").build());
        usuarios.add(Usuario.builder().id(3).nombre("Mario").apellidos("Berron Spilez").build());
        usuarios.add(Usuario.builder().id(4).nombre("Mariano").apellidos("Martinez Guerrillas").build());
        return usuarios;

    }
}
