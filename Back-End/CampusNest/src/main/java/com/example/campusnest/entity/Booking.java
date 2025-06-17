package com.example.campusnest.entity;


import com.example.campusnest.utils.BookingStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity

public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false, name = "booking_id")
    private Long id; // Unique identifier for the booking
    @ManyToOne
    @JoinColumn(nullable = false, name = "Student_id")
    private User student; // The user who made the booking
    @ManyToOne
    @JoinColumn(nullable = false, name = "room_id")
    private Room room;
    @Column(name = "preferred_roommate_name")
    private String preferredRoommateName; // optional input by name or tag
    @Column(nullable = false, name = "booking_date")
    private String bookingDate; // Date of the booking in "YYYY-MM-DD" format
    @Column(nullable = false, name = "status")
    private BookingStatus status; // e.g., "CONFIRMED", "CANCELLED", "PENDING"

    public Booking() {
        // Default constructor
    }
}
