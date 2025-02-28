package org.iesch.ad.EjerciciosBasicosSecurity.services;

import org.iesch.ad.EjerciciosBasicosSecurity.models.DTOs.UserEntityDTO;
import org.iesch.ad.EjerciciosBasicosSecurity.models.UserEntity;
import org.iesch.ad.EjerciciosBasicosSecurity.repositories.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserEntityRepository userEntityRepository;

    public List<UserEntityDTO> devuelveUserDTO() {

        List<UserEntity> userEntityList = userEntityRepository.findAll();

        List<UserEntityDTO> userEntityDTOS = new ArrayList<>();

        userEntityList.forEach(userEntity -> {
            UserEntityDTO userEntityDTO = new UserEntityDTO(
                    userEntity.getId(),
                    userEntity.getUsername(),
                    userEntity.getRoles(),
                    userEntity.getCreaccionUsuario(),
                    userEntity.getInicionSesiada()
            );

            userEntityDTOS.add(userEntityDTO);

        });

        return userEntityDTOS;
    }
}
