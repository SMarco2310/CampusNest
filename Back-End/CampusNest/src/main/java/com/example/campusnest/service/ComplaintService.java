package com.example.campusnest.service;

import com.example.campusnest.entity.Complaint;
import com.example.campusnest.repository.ComplaintRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintService {

    private final ComplaintRepository complaintRepository;

    public ComplaintService(ComplaintRepository complaintRepository) {
        this.complaintRepository = complaintRepository;
    }

    // Add methods to handle complaints, e.g., create, update, delete, fetch complaints

    public void createComplaint(Complaint complaint) {
        // This could involve creating a Complaint entity and saving it to the repository
        complaintRepository.save(complaint);
    }

    public List<Complaint> getAllComplaints() {
        // This method retrieves all complaints from the repository
        return complaintRepository.findAll();
    }

    public List<Complaint> getAllComplaintByHostel(Long hostelId) {
        // This method retrieves all complaints associated with a specific hostel
        return complaintRepository.findAllByHostelId(hostelId);
    }
}
