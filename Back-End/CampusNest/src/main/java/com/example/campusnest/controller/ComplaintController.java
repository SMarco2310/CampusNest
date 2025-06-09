package com.example.campusnest.controller;


import com.example.campusnest.entity.Complaint;
import com.example.campusnest.service.ComplaintService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller("/complaints")
public class ComplaintController {


    private final ComplaintService complaintService;

    public ComplaintController(ComplaintService complaintService) {
        this.complaintService = complaintService;
    }

    @PostMapping("/complaint")
    public ResponseEntity<String> createComplaint(@RequestBody Complaint complaint) {
        // Logic to create a complaint will be implemented here
        complaintService.createComplaint(complaint);
        return ResponseEntity.ok("Complaint created successfully"); // Placeholder response
    }

    @GetMapping("/complaints")
    public ResponseEntity<List<Complaint>> getAllComplaints() {
        // Logic to retrieve all complaints will be implemented here
        List<Complaint> complaints = complaintService.getAllComplaints();
        return ResponseEntity.ok(complaints); // Placeholder response
    }

    @GetMapping("/{hostelId}")
    public ResponseEntity<List<Complaint>> getComplaintsByHostelId(Long hostelId) {
        // Logic to retrieve complaints by hostel ID will be implemented here
        List<Complaint> complaints = complaintService.getAllComplaintByHostel(hostelId); // Placeholder logic
        return ResponseEntity.ok(complaints); // Placeholder response
    }


}
