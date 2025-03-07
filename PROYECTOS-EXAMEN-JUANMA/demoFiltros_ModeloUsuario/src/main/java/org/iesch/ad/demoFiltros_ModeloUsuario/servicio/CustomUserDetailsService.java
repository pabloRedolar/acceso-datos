package org.iesch.ad.demoFiltros_ModeloUsuario.servicio;

import org.iesch.ad.demoFiltros_ModeloUsuario.modelo.UserEntity;
import org.iesch.ad.demoFiltros_ModeloUsuario.repositorio.UserEntityRepository;
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
    private UserEntityRepository userEntityRepository;




    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userEntityService.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        userEntity.setLastLogin(LocalDateTime.now());
       userEntityRepository.save(userEntity);
        System.out.println(userEntity);
        return userEntity; // Nueva forma.
    }
}
