package org.iesch.ad.demosPendientesUD04.controllers;

import jakarta.validation.Valid;
import org.iesch.ad.demosPendientesUD04.models.Usuario;
import org.iesch.ad.demosPendientesUD04.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.io.IOException;

@RestController
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @PostMapping("/usuario")
    public ResponseEntity<?> nuevoUsuario(@Valid @RequestBody Usuario usuario) {
        try {
            if (usuario.getPassword().equals(usuario.getPasswordConfirm())) {
                return ResponseEntity.ok(usuarioRepository.save(usuario));
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }

        } catch (ResponseStatusException e) {
            System.out.println(e.getReason());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getReason());
        }
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
// Validar el archivo
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El archivo está vacío");
        }
// Validar tamaño del archivo (ejemplo: máximo 5MB)
        if (file.getSize() > 5 * 1024 * 1024) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El archivo es demasiado grande");
        }
// Validar extensión del archivo
        String fileName = file.getOriginalFilename();
        if (fileName != null && !fileName.endsWith(".txt")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Solo se permiten archivos.txt");
        }
// Guardar el archivo en el servidor
        try {
            File dest = new File("uploads/" + fileName);
            file.transferTo(dest);
            return ResponseEntity.status(HttpStatus.OK).body("Archivo subido exitosamente");

        } catch (IOException e) {
            System.out.println(e.getCause());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar el archivo");
        }
    }
}

