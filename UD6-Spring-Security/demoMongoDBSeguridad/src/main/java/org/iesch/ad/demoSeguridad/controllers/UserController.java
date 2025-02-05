package org.iesch.ad.demoSeguridad.controllers;

import org.iesch.ad.demoSeguridad.models.UserEntity;
import org.iesch.ad.demoSeguridad.services.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserEntityService userEntityService;

    @PostMapping("/")
    public ResponseEntity<?> guardarUsuario(@RequestBody UserEntity userEntity) {

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(userEntityService.nuevoUsuario(userEntity));
        } catch (DataIntegrityViolationException e) { //Violacion de la las restricciones de la base de datos (en este caso salta si ya hubiera un username igual al nuevo)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El usuario ya está en uso:" + userEntity.getUsername() + "\n" + e);

        }

//        return ResponseEntity.ok(userEntityService.nuevoUsuario(userEntity));

    }

}
