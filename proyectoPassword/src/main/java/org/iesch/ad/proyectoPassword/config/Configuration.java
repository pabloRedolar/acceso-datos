package org.iesch.ad.proyectoPassword.config;


import org.iesch.ad.proyectoPassword.model.Usuario;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean

    public ArrayList<Usuario> inicializa(){
        ArrayList<Usuario> listaUsers = new ArrayList<>();
        listaUsers.add(new Usuario("Pablo", "1234"));
        listaUsers.add(new Usuario("Manuel", "12345"));
        listaUsers.add(new Usuario("Juan", "123456"));
        return listaUsers;
    }
}
