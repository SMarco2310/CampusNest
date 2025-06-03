package com.example.campusnest.entity;


import com.example.campusnest.utils.RoomStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.net.URL;
import java.util.List;

@Setter
@Getter
@Entity

public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false, name = "room_id")
    private Long id;
    @Column(nullable = false,name = "room_number")
    private String roomNumber; // e.g., "A10", "B1"
    @Column(nullable = false,name = "facility_name")
    private String facilityName; // e.g., "fridge",  "ac" or "ceiling Fan"
    @Column(nullable = false,name = "roomStatus")
    private RoomStatus roomStatus; // true if available, false if booked
    @Column(nullable = false,name = "number_of_beds")
    private int numberOfBeds; // number of beds in the room
    @Column(nullable = false,name = "price_per_bed")
    private double pricePerBed; // price per bed per night
    @ManyToOne
    @JoinColumn(nullable = false, name = "hostel_id")
    private Hostel hostelId; // ID of the hostel this room belongs to
    @Column(name = "room_pictures", nullable = false)
    private List<String> roomPictures; // URL or path to the room pictures
}
