package com.ad.gestionDeReservasDeUnHotel.exceptions;

public class TheRoomIsAlreadyCreate extends RuntimeException {
    public TheRoomIsAlreadyCreate(String message) {
        super(message);
    }
}