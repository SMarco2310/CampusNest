package com.example.campusnest.service;

import com.example.campusnest.entity.Complaint;
import com.example.campusnest.repository.ComplaintRepository;

import java.util.List;

public class ComplaintService {

    private ComplaintRepository complaintRepository;

    public ComplaintService(ComplaintRepository complaintRepository) {
        this.complaintRepository = complaintRepository;
    }

    // Add methods to handle complaints, e.g., create, update, delete, fetch complaints

    public void createComplaint(Complaint complain) {
        // This could involve creating a Complaint entity and saving it to the repository
        complaintRepository.save(complain);
    }

    public List<Complaint> getAllComplaints() {
        // This method retrieves all complaints from the repository
        return complaintRepository.findAll();
    }
}
