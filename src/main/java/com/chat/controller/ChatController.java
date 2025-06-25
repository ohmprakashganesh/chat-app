package com.chat.controller;

import com.chat.entities.Message;
import com.chat.entities.Request;
import com.chat.entities.Room;
import com.chat.exception.NotFound;
import com.chat.repo.RoomRepo;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
@CrossOrigin("*")
public class ChatController {

    private final RoomRepo roomRepo;
    //for sending and reciving message

    @MessageMapping("/sendMessage/{roomId}")
    @SendTo("/topic/room/{roomId}")
    public Message sendMessage(
            @DestinationVariable String roomId,
             Request request
            ){

        Room room=roomRepo.findByRoomId(request.getRoomId());
         Message message=new Message();
         message.setSender(request.getSender());
         message.setContent(request.getContent());
         message.setTimeStamp(LocalDateTime.now());

         if(room != null){
             room.getMessages().add(message);
             roomRepo.save(room);
         }else{
             throw  new NotFound("room not found");
         }

         return  message;


    }



}
