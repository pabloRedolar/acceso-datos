package org.iesch.ad.demoSeguridad.services;

import org.iesch.ad.demoSeguridad.models.UserEntity;
import org.iesch.ad.demoSeguridad.models.UserRole;
import org.iesch.ad.demoSeguridad.repositories.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserEntityService {

    @Autowired
    UserEntityRepository userEntityRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public UserEntity nuevoUsuario(UserEntity userEntity) {
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userEntity.setRoles(Set.of(UserRole.USER));

        return userEntityRepository.save(userEntity);


    }
}
