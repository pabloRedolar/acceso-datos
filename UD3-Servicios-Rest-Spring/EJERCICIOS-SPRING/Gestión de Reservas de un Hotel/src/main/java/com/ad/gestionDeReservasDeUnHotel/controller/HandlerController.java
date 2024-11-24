package com.ad.gestionDeReservasDeUnHotel.controller;

import com.ad.gestionDeReservasDeUnHotel.exceptions.*;
import com.ad.gestionDeReservasDeUnHotel.model.errorDTO.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.time.LocalDateTime;

@RestControllerAdvice
public class HandlerController {

    @ExceptionHandler({NoHandlerFoundException.class, NoResourceFoundException.class})
    public ResponseEntity<ErrorDTO> noHandlerFoundException(Exception ex) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setError("api no encontrada");
        errorDTO.setMessage(ex.getMessage());
        errorDTO.setTimeStamp(LocalDateTime.now());
        errorDTO.setStatus(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDTO);
    }

    @ExceptionHandler(TheUserIsAlreadyCreate.class)
    public ResponseEntity<ErrorDTO> theUserIsAlreadyCreateEx(Exception ex) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setError("el usuario ya esta creado");
        errorDTO.setMessage(ex.getMessage());
        errorDTO.setTimeStamp(LocalDateTime.now());
        errorDTO.setStatus(HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDTO);
    }

    @ExceptionHandler(TheBookingIsAlreadyCreate.class)
    public ResponseEntity<ErrorDTO> theBookingIsAlreadyCreateEx(Exception ex) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setError("la reseva ya esta creada");
        errorDTO.setMessage(ex.getMessage());
        errorDTO.setTimeStamp(LocalDateTime.now());
        errorDTO.setStatus(HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDTO);
    }

    @ExceptionHandler(TheRoomIsAlreadyCreate.class)
    public ResponseEntity<ErrorDTO> theRoomIsAlreadyCreate(Exception ex) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setError("la habitacion ya existe");
        errorDTO.setMessage(ex.getMessage());
        errorDTO.setTimeStamp(LocalDateTime.now());
        errorDTO.setStatus(HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDTO);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDTO> userNotFoundException(Exception ex) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setError("el usuario no se encontro");
        errorDTO.setMessage(ex.getMessage());
        errorDTO.setTimeStamp(LocalDateTime.now());
        errorDTO.setStatus(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDTO);
    }

    @ExceptionHandler(RoomNotFoundException.class)
    public ResponseEntity<ErrorDTO> roomNotFoundException(Exception ex) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setError("la habitacion no se encontro");
        errorDTO.setMessage(ex.getMessage());
        errorDTO.setTimeStamp(LocalDateTime.now());
        errorDTO.setStatus(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDTO);
    }

    @ExceptionHandler(TheRoomIsNotAvailable.class)
    public ResponseEntity<ErrorDTO> theRoomisNotAvailable(Exception ex) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setError("la habitacion no esta disponible");
        errorDTO.setMessage(ex.getMessage());
        errorDTO.setTimeStamp(LocalDateTime.now());
        errorDTO.setStatus(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDTO);
    }

    @ExceptionHandler(BookingNotFoundException.class)
    public ResponseEntity<ErrorDTO> bookingNotFoundException(Exception ex) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setError("reserva no encontrada");
        errorDTO.setMessage(ex.getMessage());
        errorDTO.setTimeStamp(LocalDateTime.now());
        errorDTO.setStatus(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDTO);
    }
}