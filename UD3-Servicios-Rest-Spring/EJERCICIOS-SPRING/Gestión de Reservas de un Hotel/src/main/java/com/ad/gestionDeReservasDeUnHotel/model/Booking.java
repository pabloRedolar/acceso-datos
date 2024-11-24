package com.ad.gestionDeReservasDeUnHotel.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@Builder
@EqualsAndHashCode
public class Booking {

    long bookingId;
    long userId;
    long roomId;
    Room.RoomType roomType;
    Date entryDate;
    Date clearDate;
    int numberOfPeople;
}
