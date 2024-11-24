package com.ad.gestionDeReservasDeUnHotel.exceptions;

public class TheBookingIsAlreadyCreate extends RuntimeException {
    public TheBookingIsAlreadyCreate(String message) {
        super(message);
    }
}