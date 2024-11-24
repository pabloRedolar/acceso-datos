package com.ad.gestionDeReservasDeUnHotel.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@Builder
@EqualsAndHashCode
public class Room {

    public enum RoomType {
        SIMPLE(50.0),
        DOUBLE(80.0),
        SUITE(150.0);

        private final double rate;

        RoomType(double rate) {
            this.rate = rate;
        }

        public double getRate() {
            return rate;
        }
    }

    public enum RoomStatus {
        AVAILABLE, OUT_OF_SERVICE
    }

    long id;
    RoomType roomType;
    RoomStatus roomStatus;
    double roomCoast;
}