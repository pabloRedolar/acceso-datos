package org.iesch.ad.EjerciciosBasicosSecurity.controllers;

import org.iesch.ad.EjerciciosBasicosSecurity.models.UserEntity;
import org.iesch.ad.EjerciciosBasicosSecurity.repositories.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/UserEntity")
public class UserEntityController {

    @Autowired
    UserEntityRepository userEntityRepository;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UserEntity userEntity) {

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userEntityRepository.save(userEntity));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestParam String username, @RequestBody UserEntity userEntity) {

    }
}
