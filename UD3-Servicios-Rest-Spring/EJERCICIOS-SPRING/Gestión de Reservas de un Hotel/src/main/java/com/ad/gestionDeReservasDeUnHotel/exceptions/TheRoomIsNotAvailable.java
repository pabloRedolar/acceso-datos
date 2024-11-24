package com.ad.gestionDeReservasDeUnHotel.exceptions;

public class TheRoomIsNotAvailable extends RuntimeException {
    public TheRoomIsNotAvailable(String message) {
        super(message);
    }
}