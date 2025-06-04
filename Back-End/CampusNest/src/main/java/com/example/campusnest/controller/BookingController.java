package com.example.campusnest.controller;

import com.example.campusnest.entity.Booking;
import com.example.campusnest.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {


    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<BookingResponse> bookRoom(@RequestBody Booking request) {
        return ResponseEntity.ok(bookingService.bookRoom(request));
    }

    @GetMapping
    public ResponseEntity<BookingResponse> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }
}

