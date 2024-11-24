package com.ad.gestionDeUsuariosYContrasenyas.model.errorDTO;

import lombok.Data;

import java.util.Date;

@Data
public class ErrorDTO {
    String error;
    String message;
    int status;
    Date date;
}