package org.iesch.ad.demoFiltros_ModeloUsuario.servicio;

import org.iesch.ad.demoFiltros_ModeloUsuario.modelo.UserEntity;
import org.iesch.ad.demoFiltros_ModeloUsuario.repositorio.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserEntityService {

    @Autowired
    UserEntityRepository userEntityRepository;

    public Optional<UserEntity> findByUsername(String username){
        return userEntityRepository.findByUsername(username);
    }
}
