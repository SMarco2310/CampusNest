package com.example.campusnest.controller;

import com.example.campusnest.entity.Hostel;
import com.example.campusnest.repository.HostelRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller("/api/v1/hostels")
public class HostelController {

    private final HostelRepository hostelRepository;

    public HostelController(HostelRepository hostelRepository) {
        this.hostelRepository = hostelRepository;
    }


    @GetMapping

    public ResponseEntity<List<Hostel>> getAll() {
        return ResponseEntity.ok(hostelRepository.findAll());
    }

    @GetMapping("/hostels/{id}")
    public ResponseEntity<Hostel> getHostelById(long id) {
        return hostelRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/hostel/update")
    public ResponseEntity<Hostel> updateHostel(Hostel hostel) {
        if (hostelRepository.existsById(hostel.getId())) {
            Hostel updatedHostel = hostelRepository.save(hostel);
            return ResponseEntity.ok(updatedHostel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
