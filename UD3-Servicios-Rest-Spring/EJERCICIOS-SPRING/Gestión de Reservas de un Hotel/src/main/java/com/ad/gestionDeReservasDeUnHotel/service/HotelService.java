package com.ad.gestionDeReservasDeUnHotel.service;

import com.ad.gestionDeReservasDeUnHotel.exceptions.*;
import com.ad.gestionDeReservasDeUnHotel.model.Booking;
import com.ad.gestionDeReservasDeUnHotel.model.Room;
import com.ad.gestionDeReservasDeUnHotel.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HotelService {

    @Autowired
    Map<Long, User> userMap;

    @Autowired
    Map<Long, Room> roomMap;

    @Autowired
    Map<Long, Booking> bookingMap;

    public Map<Long, User> getAllUsers() {
        return userMap;
    }

    public Map<Long, Room> getAllRooms() {
        return roomMap;
    }

    public Map<Long, Booking> getAllBookings() {
        return bookingMap;
    }

    public User getUser(long id) {
        if (!userMap.containsKey(id)) {
            throw new UserNotFoundException("no se ha encontrado el usuario");
        }

        return userMap.get(id);
    }

    public Room getRoom(long id) {
        if (!roomMap.containsKey(id)) {
            throw new RoomNotFoundException("no se ha encontrado la habitacion");
        }

        return roomMap.get(id);
    }

    public Booking getBooking(long id) {
        if (!userMap.containsKey(id)) {
            throw new BookingNotFoundException("no se ha encontrado la reserva");
        }

        return bookingMap.get(id);
    }

    public Boolean isTheRoomAvailability(long roomId, Date entryDate, Date clearDate) {
        return bookingMap.values().stream()
                .filter(b -> b.getRoomId() == roomId)
                .noneMatch(b -> entryDate.before(b.getClearDate()) && clearDate.after(b.getEntryDate()) &&
                        !entryDate.equals(b.getClearDate()) && !clearDate.equals(b.getEntryDate()));
    }

    public Boolean createUser(User user) {
        if (userMap.containsKey(user.getId())) {
            throw new TheUserIsAlreadyCreate("el usuario ya esta creado");
        }

        long lenght = userMap.size() + 1;
        userMap.put(lenght, User.builder().id(lenght).name(user.getName()).email(user.getEmail()).build());

        return true;
    }

    public Boolean createRoom(Room room) {
        if (roomMap.containsKey(room.getId())) {
            throw new TheRoomIsAlreadyCreate("la habitacion ya esta creada");
        }

        long lenght = userMap.size() + 1;
        roomMap.put(lenght, Room.builder().id(lenght).roomType(room.getRoomType()).roomStatus(room.getRoomStatus())
                .roomCoast(room.getRoomCoast()).build());

        return true;
    }

    public Boolean createBooking(Booking booking) {
        if (bookingMap.containsKey(booking.getBookingId())) {
            throw new TheBookingIsAlreadyCreate("la reserva ya esta creada");
        }

        if (!userMap.containsKey(booking.getUserId())) {
            throw new UserNotFoundException("no se encontro al usuario");
        }

        if (!roomMap.containsKey(booking.getRoomId())) {
            throw new RoomNotFoundException("no se encontro la habitacion");
        }

        if (!isTheRoomAvailability(booking.getRoomId(), booking.getEntryDate(), booking.getClearDate())) {
            throw new TheRoomIsNotAvailable("la habitacion no está disponible para las fechas seleccionadas");
        }

        Room.RoomType roomType = roomMap.values().stream().filter(room -> room.getId() == booking.getRoomId())
                .map(Room::getRoomType).findFirst().orElseThrow(() -> new RoomNotFoundException("no se encontro la habitacion"));

        Room.RoomStatus roomStatus = roomMap.values().stream().filter(room -> room.getId() == booking.getRoomId())
                .map(Room::getRoomStatus).findAny().orElseThrow(() -> new RoomNotFoundException("no se encontro la habitacion"));

        if (roomStatus != Room.RoomStatus.AVAILABLE) {
            throw new TheRoomIsNotAvailable("la habitacion es reservada");
        }

        long lenght = userMap.size() + 1;
        bookingMap.put(lenght, Booking.builder().bookingId(lenght).userId(booking.getUserId()).roomId(booking.getRoomId())
                .entryDate(booking.getEntryDate()).clearDate(booking.getClearDate()).numberOfPeople(booking.getNumberOfPeople())
                .roomType(roomType).build());

        return true;
    }

    public Boolean roomAvailability(Room.RoomType roomType, Date entryDate, Date clearDate) {
        List<Room> roomAvailabilityList = new ArrayList<>(roomMap.values().stream()
                .filter(r -> r.getRoomType().equals(roomType) && r.getRoomStatus() != Room.RoomStatus.OUT_OF_SERVICE).toList());

        for (Map.Entry<Long, Booking> i : bookingMap.entrySet()) {
            Booking booking = i.getValue();
            long bookingId = booking.getBookingId();

            roomAvailabilityList.removeIf(r -> i.getKey() == r.getId() && !entryDate.before(booking.getEntryDate())
                    && !clearDate.after(booking.getClearDate()) && entryDate.after(new Date()) && clearDate.after(new Date()));
        }

        return !roomAvailabilityList.isEmpty();
    }

    public Boolean deleteBooking(long userId, long bookingId) {
        if (!bookingMap.containsKey(bookingId)) {
            throw new BookingNotFoundException("reserva no encontrada");
        }

        long roomId = bookingMap.values().stream().filter(b -> b.getBookingId() == bookingId)
                .map(Booking::getRoomId).findFirst().orElseThrow(() -> new BookingNotFoundException("reserva no encontrada"));

        bookingMap.remove(bookingId);
        return true;
    }
}