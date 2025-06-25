package com.chat.controller;

import com.chat.entities.Message;
import com.chat.entities.Room;
import com.chat.repo.RoomRepo;
import com.chat.services.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/room")
@RequiredArgsConstructor
@CrossOrigin("*")
public class RoomController {

    private  final RoomService roomService;
    private  final RoomRepo roomRepo;

    //create room
    @PostMapping
    public ResponseEntity< Room > createRoom(@RequestBody Room room){

        return  new ResponseEntity<>(roomService.createRoom(room),HttpStatus.CREATED) ;
    }
    //get room
    @GetMapping("/JoinRoom/{roomId}")
    public ResponseEntity<Room> join(@PathVariable String roomId){
       return new ResponseEntity<>(roomService.getRoom(roomId.trim()), HttpStatus.ACCEPTED);
    }
    @GetMapping("/all")
    public ResponseEntity< List<Room> >rooms (){
        return  ResponseEntity.ok().body(roomRepo.findAll());
    }
    //get message of room
    @GetMapping("/{roomId}/messages")
    public ResponseEntity<List<Message>> getMessages(@PathVariable String roomId, @RequestParam(value = "page" ,defaultValue="0", required = false) int page, @RequestParam(value = "size",defaultValue = "20", required = false)int size
    ){
        Room room= roomService.getRoom(roomId.trim());
        if(room==null){
            return ResponseEntity.badRequest().build();
        }
        List<Message> messages= room.getMessages();
        int start= Math.max(0,messages.size()-(page+1)*size);
        int end= Math.min(messages.size(), start+size);
        List<Message> paginatedMessages= messages.subList(start,end);
        return ResponseEntity.ok(paginatedMessages);
    }


}
