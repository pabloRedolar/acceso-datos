package com.ad.gestionDeUsuariosYContrasenyas.controller;

import com.ad.gestionDeUsuariosYContrasenyas.exceptions.*;
import com.ad.gestionDeUsuariosYContrasenyas.model.errorDTO.ErrorDTO;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.Date;

@RestControllerAdvice
public class HandlerController {

    ErrorDTO errorDTO = new ErrorDTO();

    @ExceptionHandler({NoHandlerFoundException.class, NoResourceFoundException.class})
    public ResponseEntity<ErrorDTO> apiEx(Exception ex) {
        errorDTO.setError("api no encontrada");
        errorDTO.setMessage(ex.getMessage());
        errorDTO.setDate(new Date());
        errorDTO.setStatus(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDTO);
    }

    @ExceptionHandler(PasswordIsNotValidException.class)
    public ResponseEntity<ErrorDTO> passwordExceptionEx(Exception ex) {
        errorDTO.setError("error de contraseña");
        errorDTO.setMessage(ex.getMessage());
        errorDTO.setDate(new Date());
        errorDTO.setStatus(HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDTO);
    }

    @ExceptionHandler(UserIsInsideException.class)
    public ResponseEntity<ErrorDTO> userIsInsideEx(Exception ex) {
        errorDTO.setError("el usuario ya se encuentra dentro");
        errorDTO.setMessage(ex.getMessage());
        errorDTO.setDate(new Date());
        errorDTO.setStatus(HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDTO);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDTO> userNotFoundEx(Exception ex) {
        errorDTO.setError("no se encontro el user");
        errorDTO.setMessage(ex.getMessage());
        errorDTO.setDate(new Date());
        errorDTO.setStatus(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDTO);
    }

    @ExceptionHandler(DeleteUserException.class)
    public ResponseEntity<ErrorDTO> deleteUserEx(Exception ex) {
        errorDTO.setError("no pudiste eliminar el user");
        errorDTO.setMessage(ex.getMessage());
        errorDTO.setDate(new Date());
        errorDTO.setStatus(HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDTO);
    }

    @ExceptionHandler(IsOnTheListException.class)
    public ResponseEntity<ErrorDTO> isOnTheListEx(Exception ex) {
        errorDTO.setError("ya esta en la lista palomo");
        errorDTO.setMessage(ex.getMessage());
        errorDTO.setDate(new Date());
        errorDTO.setStatus(HttpStatus.NO_CONTENT.value());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(errorDTO);
    }

    @ExceptionHandler(PasswordIsNotSure.class)
    public ResponseEntity<ErrorDTO> passwordIsNotSure(Exception ex) {
        errorDTO.setError("la contraseña no es segura");
        errorDTO.setMessage(ex.getMessage());
        errorDTO.setDate(new Date());
        errorDTO.setStatus(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDTO);
    }
}