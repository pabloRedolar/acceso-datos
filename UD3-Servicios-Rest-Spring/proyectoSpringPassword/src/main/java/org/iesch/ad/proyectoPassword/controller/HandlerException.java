package org.iesch.ad.proyectoPassword.controller;

import org.iesch.ad.proyectoPassword.erroresDTO.UsuarioErrorDTO;
import org.iesch.ad.proyectoPassword.exceptions.PasswordNotStrongException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice

public class HandlerException {
    //Cuando la contraseña no esc opleja

    @ExceptionHandler({PasswordNotStrongException.class})
    public ResponseEntity<?> ContrasennaNoComplejaExcepcion(Exception ex){
        UsuarioErrorDTO errorDTO = new UsuarioErrorDTO();
        errorDTO.setMessage(errorDTO.getMessage());
        errorDTO.setDate(LocalDateTime.now());
        errorDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorDTO.setError("Conttraseña insegura");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(errorDTO);
    }
}
