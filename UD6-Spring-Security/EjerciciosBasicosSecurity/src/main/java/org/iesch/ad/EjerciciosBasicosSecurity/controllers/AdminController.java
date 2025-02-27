package org.iesch.ad.EjerciciosBasicosSecurity.controllers;

import org.iesch.ad.EjerciciosBasicosSecurity.exceptions.UserPasswordException;
import org.iesch.ad.EjerciciosBasicosSecurity.models.UserEntity;
import org.iesch.ad.EjerciciosBasicosSecurity.models.UserRole;
import org.iesch.ad.EjerciciosBasicosSecurity.repositories.UserEntityRepository;
import org.iesch.ad.EjerciciosBasicosSecurity.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.password.CompromisedPasswordException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    UserEntityRepository userEntityRepository;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UserEntity userEntity) {

        return ResponseEntity.status(HttpStatus.OK).body(adminService.guardarUsuario(userEntity));

    }

    @GetMapping("/read")
    public ResponseEntity<?> readUser() {

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userEntityRepository.findAll());
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestParam Long id, @RequestBody UserEntity userEntity) {

        UserEntity entity = userEntityRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("No se encuentra"));

        entity.setUsername(userEntity.getUsername());
        entity.setPassword(userEntity.getPassword());

        userEntityRepository.save(entity);

        return ResponseEntity.ok(entity);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteUser(@RequestParam Long id) {

        userEntityRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        userEntityRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
