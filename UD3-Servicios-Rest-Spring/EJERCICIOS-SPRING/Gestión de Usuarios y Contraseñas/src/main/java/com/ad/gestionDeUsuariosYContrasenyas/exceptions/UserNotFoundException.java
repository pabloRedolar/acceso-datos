package com.ad.gestionDeUsuariosYContrasenyas.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
