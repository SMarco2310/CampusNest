package com.example.campusnest.controller;

import com.example.campusnest.entity.Complaint;
import com.example.campusnest.service.ComplaintService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/complaints")
public class ComplaintController {

    private final ComplaintService complaintService;

    public ComplaintController(ComplaintService complaintService) {
        this.complaintService = complaintService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createComplaint(@RequestBody Complaint complaint) {
        complaintService.createComplaint(complaint);
        return ResponseEntity.ok("Complaint created successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Complaint>> getAllComplaints() {
        List<Complaint> complaints = complaintService.getAllComplaints();
        return ResponseEntity.ok(complaints);
    }

    @GetMapping("/{hostelId}")
    public ResponseEntity<List<Complaint>> getComplaintsByHostelId(@PathVariable Long hostelId) {
        List<Complaint> complaints = complaintService.getAllComplaintByHostel(hostelId);
        return ResponseEntity.ok(complaints);
    }
}