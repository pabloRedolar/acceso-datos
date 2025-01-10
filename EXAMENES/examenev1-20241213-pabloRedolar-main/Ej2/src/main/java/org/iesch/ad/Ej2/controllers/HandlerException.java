package org.iesch.ad.Ej2.controllers;

import org.iesch.ad.Ej2.exceptions.RaquetaException;
import org.iesch.ad.Ej2.exceptions.RepresentanteException;
import org.iesch.ad.Ej2.exceptions.TenistaException;
import org.iesch.ad.Ej2.models.DTOs.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class HandlerException {
    @ExceptionHandler(RepresentanteException.class)
    public ResponseEntity<ErrorDTO> errorRepresentante(TenistaException ex) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setStatus(HttpStatus.NOT_FOUND.value());
        errorDTO.setError("Error representante");
        errorDTO.setMessage(ex.getMessage());
        errorDTO.setDateTime(LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(errorDTO);
    }

    @ExceptionHandler(TenistaException.class)
    public ResponseEntity<ErrorDTO> errorTenista(TenistaException ex) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setStatus(HttpStatus.NOT_FOUND.value());
        errorDTO.setError("Error tenista");
        errorDTO.setMessage(ex.getMessage());
        errorDTO.setDateTime(LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(errorDTO);
    }

    @ExceptionHandler(RaquetaException.class)
    public ResponseEntity<ErrorDTO> errorRaqueta(RaquetaException ex) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setStatus(HttpStatus.NOT_FOUND.value());
        errorDTO.setError("Error raqueta");
        errorDTO.setMessage(ex.getMessage());
        errorDTO.setDateTime(LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(errorDTO);
    }
}
