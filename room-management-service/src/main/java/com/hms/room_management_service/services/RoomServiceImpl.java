package com.hms.room_management_service.services;

import com.hms.room_management_service.entities.Room;
import com.hms.room_management_service.repositories.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }


    @Override
    public Room addRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public Optional<Room> getRoomById(Long id) {
        return roomRepository.findById(id);
    }

//    @Override
//    public Room updateRoom(Long id, Room room) {
//        return roomRepository.findById(id).map(existing -> {
//            existing.setRoomNumber(room.getRoomNumber());
//            existing.setType(room.getType());
//            existing.setPrice(room.getPrice());
//            existing.setAvailable(room.isAvailable());
//            return roomRepository.save(existing);
//        }).orElse(null);
//    }

    @Override
    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }
}
