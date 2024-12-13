package org.iesch.ad.ProyectoConsultasAutomoviles.controllers;

import org.iesch.ad.ProyectoConsultasAutomoviles.exceptions.ClienteInexistente;
import org.iesch.ad.ProyectoConsultasAutomoviles.model.DTO.errorDTOs.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.time.LocalDateTime;

@RestControllerAdvice
public class Exceptions_handler {
    @ExceptionHandler(ClienteInexistente.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorDTO> clienteInexistente(ClienteInexistente ex) {
        ErrorDTO errorDTO = new ErrorDTO();

        errorDTO.setStatus(HttpStatus.NOT_FOUND.value());
        errorDTO.setError("CLiente no encontrau");
        errorDTO.setMessage(ex.getMessage());
        errorDTO.setDate(LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(errorDTO);
    }

    @ExceptionHandler({NoHandlerFoundException.class, NoResourceFoundException.class})
    public ResponseEntity<ErrorDTO> apiNoEncontrada(Exception ex) {
        ErrorDTO errorDTO = new ErrorDTO();

        errorDTO.setStatus(HttpStatus.NOT_FOUND.value());
        errorDTO.setError("Api mal");
        errorDTO.setMessage(ex.getMessage());
        errorDTO.setDate(LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDTO);
    }
}
