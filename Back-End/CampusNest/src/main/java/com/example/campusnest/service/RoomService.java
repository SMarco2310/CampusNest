package com.example.campusnest.service;// ... other imports ...
import com.example.campusnest.entity.Room;
import com.example.campusnest.repository.RoomRepository;
import com.example.campusnest.repository.HostelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    private final RoomRepository roomRepository;
    private final HostelRepository hostelRepository;

    public RoomService(RoomRepository roomRepository, HostelRepository hostelRepository) {
        this.roomRepository = roomRepository;
        this.hostelRepository = hostelRepository;
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public List<Room> getAllRoomsByPricePerBeds(double startPrice, double endPrice) {
        return roomRepository.findAllByPricePerBedBetween(startPrice, endPrice);
    }

    public Room getRoomById(long id) {
        return roomRepository.findById(id).orElse(null);
    }

    public List<Room> findRoomsByHostelId(long hostelId) {
        return roomRepository.findAllByHostel_Id(hostelId);
    }

    public List<Room> findRoomsByNumberOfBeds(int numberOfBeds) {
        return roomRepository.findAllByNumberOfBeds(numberOfBeds);
    }

    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    public Room updateRoom(Room room) {
        return roomRepository.save(room);
    }

    public Room getRoomByRoomNumberAndHostel_Id(String roomNumber, Long hostelId) {
        return roomRepository.findByRoomNumberAndHostel_Id(roomNumber, hostelId);
    }
}