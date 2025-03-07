package org.iesch.ad.Ej2.controllers;

import org.iesch.ad.Ej2.excepciones.UsuarioException;
import org.iesch.ad.Ej2.models.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;


@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(UsuarioException.class)
    public ResponseEntity<?> usuarioException(UsuarioException e) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setDate(new Date());
        errorDTO.setError("Usuario no encontrao");
        errorDTO.setMessage(e.getMessage());
        errorDTO.setStatus(HttpStatus.NOT_FOUND.value());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDTO);
    }
}
