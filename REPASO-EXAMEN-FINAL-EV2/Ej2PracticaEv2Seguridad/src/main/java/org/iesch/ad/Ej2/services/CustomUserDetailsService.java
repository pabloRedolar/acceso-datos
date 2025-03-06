package org.iesch.ad.Ej2.services;

import org.iesch.ad.Ej2.models.Persona;
import org.iesch.ad.Ej2.repos.PersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    PersonaRepositorio personaRepositorio;

    @Override
    public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
        Persona persona = personaRepositorio.findByNombre(nombre)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        return persona;
    }
}
