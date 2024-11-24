package com.ad.gestionDeUsuariosYContrasenyas.exceptions;

public class UserIsInsideException extends RuntimeException {
    public UserIsInsideException(String message) {
        super(message);
    }
}