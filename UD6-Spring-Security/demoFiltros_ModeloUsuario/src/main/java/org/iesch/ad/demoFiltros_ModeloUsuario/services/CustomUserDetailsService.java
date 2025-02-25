package org.iesch.ad.demoFiltros_ModeloUsuario.services;

import org.iesch.ad.demoFiltros_ModeloUsuario.models.UserEntity;
import org.iesch.ad.demoFiltros_ModeloUsuario.repositories.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserEntityService userEntityService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userEntityService.findPorUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("No ecite"));
        return userEntity; // Nueva forma
    }
}
