package com.chat.repo;

import com.chat.entities.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Repository extends MongoRepository<Room, String> {
    //get room using room id
    Room findByRoomId(String roomId);
}
