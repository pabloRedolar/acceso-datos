package com.ad.gestionDeUsuariosYContrasenyas.exceptions;

public class PasswordIsNotSure extends RuntimeException {
    public PasswordIsNotSure(String message) {
        super(message);
    }
}
