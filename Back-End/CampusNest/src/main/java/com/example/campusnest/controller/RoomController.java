package com.example.campusnest.controller;


import com.example.campusnest.service.RoomService;
import com.example.campusnest.dto.UpdateRoom;
import com.example.campusnest.entity.Room;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Room>> getAllRooms() {
        return ResponseEntity.ok(roomService.getAllRooms());
    }

    @GetMapping("/by-price")
    public ResponseEntity<List<Room>> getRoomsByPriceRange(
            @RequestParam double startPrice,
            @RequestParam double endPrice) {
        return ResponseEntity.ok(roomService.getAllRoomsByPricePerBeds(startPrice, endPrice));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable long id) {
        Room room = roomService.getRoomById(id);
        if (room != null) {
            return ResponseEntity.ok(room);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{hostelId}")
    public ResponseEntity<List<Room>> getRoomsByHostelId(@PathVariable long hostelId) {
        List<Room> rooms = roomService.findRoomsByHostelId(hostelId);
        if (rooms != null && !rooms.isEmpty()) {
            return ResponseEntity.ok(rooms);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Room> createRoom(@RequestBody Room room) {
        Room createdRoom = roomService.createRoom(room);
        if (createdRoom != null) {
            return ResponseEntity.status(201).body(createdRoom);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Room> updateRoom(
            @PathVariable long id,
            @RequestBody UpdateRoom updateRequest) {
        Room existingRoom = roomService.getRoomById(id);
        if (existingRoom != null) {
            existingRoom.setRoomStatus(updateRequest.getRoomStatus());
            existingRoom.setNumberOfBeds(updateRequest.getNumberOfBeds());
            existingRoom.setPricePerBed(updateRequest.getPricePerBed());
            existingRoom.setRoomPictures(updateRequest.getRoomPictures().toString());
            Room updatedRoom = roomService.updateRoom(existingRoom);
            return ResponseEntity.ok(updatedRoom);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}