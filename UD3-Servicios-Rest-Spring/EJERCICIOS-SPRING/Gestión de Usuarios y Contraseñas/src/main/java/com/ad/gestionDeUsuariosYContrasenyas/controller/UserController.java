package com.ad.gestionDeUsuariosYContrasenyas.controller;

import com.ad.gestionDeUsuariosYContrasenyas.model.NewUserPassword;
import com.ad.gestionDeUsuariosYContrasenyas.service.UserService;
import com.ad.gestionDeUsuariosYContrasenyas.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<?> userRegister(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.userRegister(user));
    }

    @GetMapping("/returnUsers")
    public ResponseEntity<?> returnUser() {
        return ResponseEntity.ok(userService.returnUsers());
    }

    @PostMapping("/userLogin")
    public ResponseEntity<?> userLogin(@RequestBody User user) {
        return ResponseEntity.ok(userService.userLogin(user.getEmail(), user.getPassword()));
    }

    @GetMapping("/dateValidity/{email}")
    public ResponseEntity<?> dateValidity(@PathVariable String email, @RequestBody User user) {
        return ResponseEntity.ok(userService.paswordValidity(email, user));
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity<?> deleteUser(@RequestBody User user) {
        boolean isDeleted = (boolean) userService.deleterUser(user);
        if (isDeleted) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/updatePassword")
    public ResponseEntity<?> updatePassword(@RequestBody NewUserPassword newUserPassword) {
        return ResponseEntity.ok(userService.updatePassword(newUserPassword));
    }
}