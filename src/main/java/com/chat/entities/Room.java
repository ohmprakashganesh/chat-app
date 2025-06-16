package com.chat.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collation = "rooms")
public class Room {
    @Id
    private String id; //monog ko unique id auto create
    private String roomId; //user created
    private List<Message> messages= new ArrayList<>();

}
