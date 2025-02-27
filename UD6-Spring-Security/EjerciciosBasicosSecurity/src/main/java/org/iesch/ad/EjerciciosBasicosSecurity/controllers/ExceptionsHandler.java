package org.iesch.ad.EjerciciosBasicosSecurity.controllers;

import org.iesch.ad.EjerciciosBasicosSecurity.exceptions.UserPasswordException;
import org.iesch.ad.EjerciciosBasicosSecurity.models.DTOs.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler({UserPasswordException.class})
    public ResponseEntity<ErrorDTO> passwordWeak(Exception e) {
        ErrorDTO errorDTO = new ErrorDTO(e.getMessage(),
                "Contraseña débil",
                HttpStatus.BAD_REQUEST.value());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(errorDTO);
    }
}
