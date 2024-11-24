package com.ad.gestionDeReservasDeUnHotel.model.errorDTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorDTO {

    String error;
    String message;
    int Status;
    LocalDateTime timeStamp;
}