package org.iesch.ad.EjerciciosBasicosSecurity.services;

import org.iesch.ad.EjerciciosBasicosSecurity.exceptions.UserPasswordException;
import org.iesch.ad.EjerciciosBasicosSecurity.models.UserEntity;
import org.iesch.ad.EjerciciosBasicosSecurity.models.UserRole;
import org.iesch.ad.EjerciciosBasicosSecurity.repositories.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AdminService {

    @Autowired
    PasswordEncoder passwordEncoderConfig;

    @Autowired
    private UserEntityRepository userEntityRepository;

    public UserEntity guardarUsuario(UserEntity userEntity) {

        if (comprobarPassword(userEntity.getPassword())) {
            userEntity.setPassword(passwordEncoderConfig.encode(userEntity.getPassword()));

            userEntity.setRoles(Set.of(UserRole.ADMIN));

            userEntityRepository.save(userEntity);

            return userEntity;

        } else {
            throw new UserPasswordException("La contraseña es insegura (1 mayus, 1 minus, 1 caracter especial)");
        }
    }

    public boolean comprobarPassword(String password) {
        return password.length() >= 8 &&
                password.chars().anyMatch(Character::isUpperCase) &&
                password.chars().anyMatch(Character::isLowerCase) &&
                password.chars().anyMatch(c -> !Character.isLetterOrDigit(c));
    }

}
