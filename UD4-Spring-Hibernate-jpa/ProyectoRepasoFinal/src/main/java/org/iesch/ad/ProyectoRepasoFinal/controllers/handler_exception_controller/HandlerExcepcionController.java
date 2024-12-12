package org.iesch.ad.ProyectoRepasoFinal.controllers.handler_exception_controller;

import org.iesch.ad.ProyectoRepasoFinal.exceptions.PedidoException;
import org.iesch.ad.ProyectoRepasoFinal.model.DTOs.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.Date;

@RestControllerAdvice
public class HandlerExcepcionController {

    @ExceptionHandler(PedidoException.class)
    public ResponseEntity<ErrorDTO> pedidoException(Exception ex) {
        ErrorDTO errorDTO = new ErrorDTO();

        errorDTO.setMessage(ex.getMessage());
        errorDTO.setError("Error pedidos");
        errorDTO.setDate(new Date());
        errorDTO.setStatus(HttpStatus.NOT_FOUND.value());

        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(errorDTO);
    }


    @ExceptionHandler({NoResourceFoundException.class, NoHandlerFoundException.class})
    public ResponseEntity<ErrorDTO> apiNotFoundException(Exception ex) {
        ErrorDTO errorDTO = new ErrorDTO();

        errorDTO.setMessage(ex.getMessage());
        errorDTO.setError("Error api no encontrada");
        errorDTO.setDate(new Date());
        errorDTO.setStatus(HttpStatus.NOT_FOUND.value());

        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(errorDTO);
    }
}
