package com.example.campusnest.service;

import com.example.campusnest.entity.Hostel;
import com.example.campusnest.repository.HostelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostelService {

    private final HostelRepository hostelRepository;

    public HostelService(HostelRepository hostelRepository) {
        this.hostelRepository = hostelRepository;
    }

    public Hostel createHostel(Hostel hostel) {
        // **CRITICAL FIX:**
        // Spring's @RequestBody has already mapped the JSON fields to your 'hostel' object.
        // You just need to save this object directly.
        // Remove the manual mapping which caused NullPointerExceptions due to missing fields.
        return hostelRepository.save(hostel);
    }

    public List<Hostel> getHostels() {
        return hostelRepository.findAll();
    }

//    public Hostel getHostelById(long id) {
//        // Improved error handling for when the ID is not found
//        return hostelRepository.findById(id)
//                .orElseThrow(() -> new NoSuchElementException("Hostel not found with ID: " + id));
//    }

}