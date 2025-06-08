package com.example.campusnest.service;

import com.example.campusnest.entity.Hostel;
import com.example.campusnest.entity.Room;
import com.example.campusnest.repository.HostelRepository;
import com.example.campusnest.repository.RoomRepository;
import com.example.campusnest.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private final RoomRepository roomRepository;
    private final HostelRepository hostelRepository;

    public RoomService(RoomRepository roomRepository, HostelRepository hostelRepository) {
        // Constructor injection for RoomRepository
        this.roomRepository = roomRepository;
        this.hostelRepository = hostelRepository;
    }
    // Additional methods for room management can be added here
    public List<Room> getAllRooms() {
        // Example method to retrieve all rooms
        return roomRepository.findAll();
    }
    public List<Room> getAllRoomsByPricePerBeds(double startPrice, double endPrice) {
        // Example method to retrieve all rooms within a price range
        return roomRepository.findAllByPricePerBedBetween(startPrice, endPrice);

    }

    public Room getRoomById(long id) {
        // Example method to retrieve a room by its ID
        return roomRepository.findById(id).orElse(null);
    }

    public List<Room> findRoomsByHostelId(long hostelId) {
        Hostel hostel = hostelRepository.findById(hostelId).orElse(null);
        // Example method to find rooms by hostel ID
        return roomRepository.findAllByHostelId(hostel);
    }

    public List<Room> findRoomsByNumberOfBeds(int numberOfBeds) {
        // Example method to find rooms by number of beds
        return roomRepository.findAllByNumberOfBeds(numberOfBeds);
    }

    public Room createRoom(Room room) {
        // Example method to create a new room
        return roomRepository.save(room);
    }
    public Room updateRoom(Room room) {
        // Example method to update a room
        return roomRepository.save(room);
    }

    public Room getRoomByRoomNumberAndHostel_Id(String roomNumber, Hostel hostelId) {
        // Example method to retrieve a room by room number and hostel ID
        return roomRepository.findByRoomNumberAndHostelId(roomNumber, hostelId);
    }
}
