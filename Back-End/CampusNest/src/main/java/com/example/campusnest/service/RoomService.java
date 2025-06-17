package com.example.campusnest.service;// ... other imports ...


import com.example.campusnest.entity.Room;
import com.example.campusnest.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    private final RoomRepository roomRepository;


    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
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
        return roomRepository.findAllByHostelId(hostelId);
    }

    public List<Room> findRoomsByNumberOfBeds(int numberOfBeds) {
        return roomRepository.findAllByNumberOfBeds(numberOfBeds);
    }

    public Room createRoom(Room room) {
        Room newRoom = new Room();
        newRoom.setRoomNumber(room.getRoomNumber());
        newRoom.setFacilityName(room.getFacilityName());
        newRoom.setNumberOfBeds(room.getNumberOfBeds());
        newRoom.setPricePerBed(room.getPricePerBed());
        newRoom.setHostel(room.getHostelId());
        newRoom.setRoomPictures(room.getRoomPictures());
        newRoom.setRoomStatus(room.getRoomStatus());
        return roomRepository.save(newRoom);
    }

    public Room updateRoom(Room room) {
        return roomRepository.save(room);
    }

    public Room getRoomByRoomNumberAndHostel_Id(String roomNumber, Long hostelId) {
        return roomRepository.findByRoomNumberAndHostelId(roomNumber, hostelId);
    }
}