package com.example.campusnest.controller;

import com.example.campusnest.entity.Hostel;
import com.example.campusnest.repository.HostelRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
}
