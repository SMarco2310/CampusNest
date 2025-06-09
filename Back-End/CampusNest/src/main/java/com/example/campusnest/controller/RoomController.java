package com.example.campusnest.controller;

import com.example.campusnest.dto.UpdateRoom;
import com.example.campusnest.entity.Room;
import com.example.campusnest.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller("/rooms")
public class RoomController {

    @Autowired
    public RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/rooms")
    public ResponseEntity<List<Room>> getAllRooms() {
        return ResponseEntity.ok(roomService.getAllRooms());
    }

    @GetMapping("/rooms/{startPrice}/{endPrice}")
    public ResponseEntity<List<Room>> getRoomsByPriceRange(double startPrice, double endPrice) {
        return ResponseEntity.ok(roomService.getAllRoomsByPricePerBeds(startPrice, endPrice));
    }

    @GetMapping("/rooms/{id}")
    public ResponseEntity<Room> getRoomById(long id) {
        Room room = roomService.getRoomById(id);
        if (room != null) {
            return ResponseEntity.ok(room);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/rooms/hostel/{hostelId}")
    public ResponseEntity<List<Room>> getRoomsByHostelId(long hostelId) {
        List<Room> rooms = roomService.findRoomsByHostelId(hostelId);
        if (rooms != null && !rooms.isEmpty()) {
            return ResponseEntity.ok(rooms);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/room")
    public ResponseEntity<Room> createRoom(@RequestBody Room room) {
        Room createdRoom = roomService.createRoom(room);
        if (createdRoom != null) {
            return ResponseEntity.status(201).body(createdRoom);
        } else {
            return ResponseEntity.badRequest().build();
        }

    }

    @PostMapping("/room/update")
    public ResponseEntity<Room> updateRoom(@RequestBody UpdateRoom room) {
        Room existingRoom = roomService.getRoomByRoomNumberAndHostel_Id(room.getRoomNumber(), room.getHostelId().getId());
        if (existingRoom != null) {
            existingRoom.setRoomStatus(room.getRoomStatus());
            existingRoom.setNumberOfBeds(room.getNumberOfBeds());
            existingRoom.setPricePerBed(room.getPricePerBed());
            existingRoom.setRoomPictures(room.getRoomPictures());
            Room updatedRoom = roomService.updateRoom(existingRoom);
            return ResponseEntity.ok(updatedRoom);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
