package com.chat.controller;

import com.chat.entities.Room;
import com.chat.services.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/room")
@RequiredArgsConstructor
public class RoomController {

    private  final RoomService roomService;

    //create room
    @PostMapping
    public Room createRoom(@RequestBody String roomId){
        if(roomService.)
    }


    //get room

    //get message of room


}
