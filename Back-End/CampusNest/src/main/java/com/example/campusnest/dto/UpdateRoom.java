package com.example.campusnest.dto;


import com.example.campusnest.utils.RoomStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
/**
 * DTO for updating room details.
 * This class is used to transfer data related to room updates.
 */
public class UpdateRoom {

    private String facilityName; // e.g., "fridge",  "ac" or "ceiling Fan"
    private String roomNumber; // e.g., "A10", "B1"
    private RoomStatus roomStatus; // true if available, false if booked
    private int numberOfBeds; // number of beds in the room
    private double pricePerBed; // price per bed per night
    private Long hostelId; // ID of the hostel this room belongs to
    private List<String> roomPictures; //
}
