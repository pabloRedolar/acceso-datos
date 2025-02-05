package org.iesch.ad.demoFiltros_ModeloUsuario.services;

import org.iesch.ad.demoFiltros_ModeloUsuario.models.UserEntity;
import org.iesch.ad.demoFiltros_ModeloUsuario.repositories.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserEntityService {
    @Autowired
    UserEntityRepository userEntityRepository;

    public Optional<UserEntity> findPorUsername(String username) {
        return userEntityRepository.findByUsername(username);

    }

}
