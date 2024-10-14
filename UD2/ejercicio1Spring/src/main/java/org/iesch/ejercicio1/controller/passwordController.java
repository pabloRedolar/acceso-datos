package org.iesch.ejercicio1.controller;

import org.iesch.ejercicio1.model.Passwd;
import org.iesch.ejercicio1.service.CrearPassword;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class passwordController {
    CrearPassword crearPassword = new CrearPassword();
    @GetMapping("/generaLetras")

    public Passwd generaLetras(){

    }

}
