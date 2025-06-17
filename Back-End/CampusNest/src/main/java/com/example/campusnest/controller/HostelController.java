package com.example.campusnest.controller;

import com.example.campusnest.entity.Hostel;
import com.example.campusnest.service.HostelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Use @RestController for REST APIs
@RequestMapping("/api/v1/hostels") // Base path for all endpoints in this controller
public class HostelController {

    private final HostelService hostelService;

    // Inject only what is needed
    public HostelController(HostelService hostelService) {
        this.hostelService = hostelService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Hostel>> getAllHostels() { // Renamed for clarity
        return ResponseEntity.ok(hostelService.getHostels());
    }
    

    @PostMapping("/create") // Use @PostMapping for creating resources
    public ResponseEntity<Hostel> createHostel(@RequestBody Hostel hostel) {
        // Return 201 Created status for successful resource creation
        Hostel createdHostel = hostelService.createHostel(hostel);
        return new ResponseEntity<>(createdHostel, HttpStatus.CREATED);
    }
}