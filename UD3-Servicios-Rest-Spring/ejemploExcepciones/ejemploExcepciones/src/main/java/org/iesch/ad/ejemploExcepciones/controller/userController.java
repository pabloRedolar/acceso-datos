package org.iesch.ad.ejemploExcepciones.controller;

import org.iesch.ad.ejemploExcepciones.excepciones.UsuarioNotFoundException;
import org.iesch.ad.ejemploExcepciones.model.Usuario;
import org.iesch.ad.ejemploExcepciones.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class userController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("api/findall")
    public ResponseEntity<?> devuelveTodos() {
        List<Usuario> lista = usuarioService.buscarTodo();
        if (lista.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(lista);
        }

    }
    @GetMapping("api/buscarPorId/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        Usuario usuario = usuarioService.buscarPorId(id).orElseThrow(()
                -> new UsuarioNotFoundException("El usuario no existe"));
        return ResponseEntity.ok(usuario);
    }
}
