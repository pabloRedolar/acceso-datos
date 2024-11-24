package com.ad.gestionDeReservasDeUnHotel.configuration;

import com.ad.gestionDeReservasDeUnHotel.model.Booking;
import com.ad.gestionDeReservasDeUnHotel.model.Room;
import com.ad.gestionDeReservasDeUnHotel.model.Room.RoomStatus;
import com.ad.gestionDeReservasDeUnHotel.model.Room.RoomType;
import com.ad.gestionDeReservasDeUnHotel.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class HotelConfiguration {

    @Bean
    public Map<Long, User> users() {
        Map<Long, User> userMap = new HashMap<>();

        for (long i = 1; i <= 10; i++) {
            userMap.put(i, User.builder().id(i).name("User " + i).email("user" + i + "@hotel.com").build());
        }

        return userMap;
    }

    @Bean
    public Map<Long, Room> rooms() {
        Map<Long, Room> roomMap = new HashMap<>();

        roomMap.put(1L, Room.builder().id(1L).roomType(Room.RoomType.SIMPLE).roomStatus(Room.RoomStatus.AVAILABLE).roomCoast(Room.RoomType.SIMPLE.getRate()).build());
        roomMap.put(2L, Room.builder().id(2L).roomType(Room.RoomType.SIMPLE).roomStatus(Room.RoomStatus.AVAILABLE).roomCoast(Room.RoomType.SIMPLE.getRate()).build());
        roomMap.put(3L, Room.builder().id(3L).roomType(Room.RoomType.SIMPLE).roomStatus(Room.RoomStatus.OUT_OF_SERVICE).roomCoast(Room.RoomType.SIMPLE.getRate()).build());
        roomMap.put(4L, Room.builder().id(4L).roomType(Room.RoomType.DOUBLE).roomStatus(Room.RoomStatus.AVAILABLE).roomCoast(Room.RoomType.DOUBLE.getRate()).build());
        roomMap.put(5L, Room.builder().id(5L).roomType(Room.RoomType.DOUBLE).roomStatus(Room.RoomStatus.AVAILABLE).roomCoast(Room.RoomType.DOUBLE.getRate()).build());
        roomMap.put(6L, Room.builder().id(6L).roomType(Room.RoomType.DOUBLE).roomStatus(Room.RoomStatus.OUT_OF_SERVICE).roomCoast(Room.RoomType.DOUBLE.getRate()).build());
        roomMap.put(7L, Room.builder().id(7L).roomType(Room.RoomType.SUITE).roomStatus(Room.RoomStatus.AVAILABLE).roomCoast(Room.RoomType.SUITE.getRate()).build());
        roomMap.put(8L, Room.builder().id(8L).roomType(Room.RoomType.SUITE).roomStatus(Room.RoomStatus.AVAILABLE).roomCoast(Room.RoomType.SUITE.getRate()).build());
        roomMap.put(9L, Room.builder().id(9L).roomType(Room.RoomType.SUITE).roomStatus(Room.RoomStatus.OUT_OF_SERVICE).roomCoast(Room.RoomType.SUITE.getRate()).build());
        roomMap.put(10L, Room.builder().id(10L).roomType(Room.RoomType.SUITE).roomStatus(Room.RoomStatus.AVAILABLE).roomCoast(Room.RoomType.SUITE.getRate()).build());

        return roomMap;
    }

    @Bean
    public Map<Long, Booking> bookings() {
        Map<Long, Booking> bookingMap = new HashMap<>();
        Map<Long, Room> roomMap = rooms();

        bookingMap.put(1L, Booking.builder().bookingId(1L).roomType(roomMap.get(2L).getRoomType()).userId(1L).numberOfPeople(1).roomId(2L).entryDate(new Date(2024 - 1900, 10, 1))
                .clearDate(new Date(2024 - 1900, 10, 5)).build());
        bookingMap.put(2L, Booking.builder().bookingId(2L).roomType(roomMap.get(5L).getRoomType()).userId(2L).numberOfPeople(2).roomId(5L).entryDate(new Date(2024 - 1900, 10, 10))
                .clearDate(new Date(2024 - 1900, 10, 15)).build());
        bookingMap.put(3L, Booking.builder().bookingId(3L).roomType(roomMap.get(8L).getRoomType()).numberOfPeople(3).userId(3L).roomId(8L).entryDate(new Date(2024 - 1900, 10, 12))
                .clearDate(new Date(2024 - 1900, 10, 18)).build());

        return bookingMap;
    }
}
