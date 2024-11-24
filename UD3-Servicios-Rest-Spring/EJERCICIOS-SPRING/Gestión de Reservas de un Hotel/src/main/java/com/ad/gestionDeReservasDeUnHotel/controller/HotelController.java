package com.ad.gestionDeReservasDeUnHotel.controller;

import com.ad.gestionDeReservasDeUnHotel.model.Booking;
import com.ad.gestionDeReservasDeUnHotel.model.Room;
import com.ad.gestionDeReservasDeUnHotel.model.User;
import com.ad.gestionDeReservasDeUnHotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Controller
@RequestMapping("hotel")
public class HotelController {

    @Autowired
    HotelService hotelService;

    @GetMapping("getAllUsers")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.getAllUsers());
    }

    @GetMapping("getAllRooms")
    public ResponseEntity<?> getAllRooms() {
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.getAllRooms());
    }

    @GetMapping("getAllBookings")
    public ResponseEntity<?> getAllBookings() {
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.getAllBookings());
    }

    @GetMapping("getUser/{id}")
    public ResponseEntity<?> getUser(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.getUser(id));
    }

    @GetMapping("getRoom/{id}")
    public ResponseEntity<?> getAllRooms(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.getRoom(id));
    }

    @GetMapping("getBooking/{id}")
    public ResponseEntity<?> getBooking(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.getBooking(id));
    }

    @PostMapping("createUser")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.createUser(user));
    }

    @PostMapping("createBooking")
    public ResponseEntity<?> createBooking(@RequestBody Booking booking) {
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.createBooking(booking));
    }

    @GetMapping("roomAvailability/{roomType}/{entryDate}/{clearDate}")
    public ResponseEntity<?> roomAvailability(@PathVariable Room.RoomType roomType, @PathVariable String entryDate,
                                              @PathVariable String clearDate) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date entry = dateFormat.parse(entryDate);
            Date clear = dateFormat.parse(clearDate);

            return ResponseEntity.status(HttpStatus.OK).body(hotelService.roomAvailability(roomType, entry, clear));
        } catch (ParseException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid date format");
        }
    }

    @DeleteMapping("deleteBooking/{userId}/{bookingId}")
    public ResponseEntity<?> deleteBooking(@PathVariable long userId, @PathVariable long bookingId) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(hotelService.deleteBooking(userId, bookingId));
    }
}