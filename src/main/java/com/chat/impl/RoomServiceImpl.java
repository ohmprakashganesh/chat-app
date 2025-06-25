package com.chat.impl;

import com.chat.exception.AlreadyExist;
import com.chat.exception.NotFound;
import com.chat.repo.RoomRepo;
import org.springframework.stereotype.Service;

import com.chat.entities.Room;
import com.chat.services.RoomService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements  RoomService {
    private final RoomRepo roomRepo;

    @Override
    public Room createRoom(Room room) {
        if(roomRepo.findByRoomId(room.getRoomId().trim())!= null){
            throw   new AlreadyExist("already breated room with id "+ room.getRoomId());

        }
      return   roomRepo.save(room);
    }

    @Override
    public Room getRoom(String roomId) {
        if(roomRepo.findByRoomId(roomId)!=null){
            return  roomRepo.findByRoomId(roomId);
        }else{
            throw  new NotFound("not found room "+roomId);
        }

    }


    
}
