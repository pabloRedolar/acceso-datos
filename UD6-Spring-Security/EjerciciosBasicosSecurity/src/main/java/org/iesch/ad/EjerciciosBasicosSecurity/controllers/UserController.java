package org.iesch.ad.EjerciciosBasicosSecurity.controllers;

import org.iesch.ad.EjerciciosBasicosSecurity.repositories.UserEntityRepository;
import org.iesch.ad.EjerciciosBasicosSecurity.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/read")
    public ResponseEntity<?> readUser() {

        return ResponseEntity.status(HttpStatus.OK).body(userService.devuelveUserDTO());
    }

}
