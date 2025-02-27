package org.iesch.ad.demoFiltros_ModeloUsuario.controlador;

import org.iesch.ad.demoFiltros_ModeloUsuario.repositorio.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/admin")
public class ZonaAdmin {

    @Autowired
    UserEntityRepository userEntityRepository;

    @GetMapping("/saludo")
    public ResponseEntity<?> saludo(){


//        HashMap hashMap = new HashMap<>();
//        hashMap.put("Saludo: " , "Hola Zona Administrador...");
        return ResponseEntity.ok(userEntityRepository.findAll());
    }



}
