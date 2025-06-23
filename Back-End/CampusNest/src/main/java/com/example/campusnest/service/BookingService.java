package com.example.campusnest.service;

import com.example.campusnest.entity.Booking;
import com.example.campusnest.entity.User;
import com.example.campusnest.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        // Constructor injection for BookingRepository
        this.bookingRepository = bookingRepository;
    }

    // Additional methods for booking management can be added here
    public Booking save(Booking booking) {
        // Example method to save a booking
        Booking newBooking= new Booking();
        newBooking.setStudent(booking.getStudent());
        newBooking.setRoom(booking.getRoom());
        newBooking.setBookingDate(booking.getBookingDate());
        newBooking.setPreferredRoommateName(booking.getPreferredRoommateName());
        newBooking.setStatus(booking.getStatus());
        return bookingRepository.save(newBooking);
    }
    // Example method to retrieve all bookings by User
    public List<Booking> getBookingByUser(User user) {
        return bookingRepository.findAllByStudent(user);
    }

    public List<Booking> getAllBookings() {
        // Example method to retrieve all bookings
        return bookingRepository.findAll();
    }
}
