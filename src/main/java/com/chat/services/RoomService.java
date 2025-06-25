package com.chat.services;

import com.chat.entities.Room;

public interface RoomService {
    Room createRoom(Room room);
    Room getRoom(String roomId);
    
}

