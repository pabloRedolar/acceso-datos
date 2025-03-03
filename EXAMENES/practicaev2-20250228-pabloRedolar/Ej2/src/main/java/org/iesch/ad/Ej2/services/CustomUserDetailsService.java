package org.iesch.ad.Ej2.services;

import org.iesch.ad.Ej2.models.Persona;
import org.iesch.ad.Ej2.repos.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserEntityService userEntityService;

    @Autowired
    private PersonaRepository userEntityRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Persona persona = userEntityService.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        userEntityRepository.save(persona);
        System.out.println(persona);
        return persona; // Nueva forma.
    }
}
