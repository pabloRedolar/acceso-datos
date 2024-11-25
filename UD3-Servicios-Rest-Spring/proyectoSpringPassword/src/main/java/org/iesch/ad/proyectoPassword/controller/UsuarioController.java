package org.iesch.ad.proyectoPassword.controller;

import org.iesch.ad.proyectoPassword.model.Usuario;
import org.iesch.ad.proyectoPassword.model.usuarioDTO.UsuarioDTO;
import org.iesch.ad.proyectoPassword.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/usuario")

public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(usuarioService.getUsuarios());
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@RequestBody UsuarioDTO usuarioDTO){
        return ResponseEntity.ok(usuarioService.addUsuario(usuarioDTO));
    }

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody UsuarioDTO usuarioDTO){
        return ResponseEntity.ok(usuarioService.login(usuarioDTO));
    }
}
