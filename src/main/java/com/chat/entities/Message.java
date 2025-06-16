package com.chat.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data@AllArgsConstructor @NoArgsConstructor
@Document
public class Message {
    private String sender;
    private String content;
    private LocalDateTime timeStamp;

    public  Message(String sender, String content){
        this.content=content;
        this.sender=sender;
        this.timeStamp=LocalDateTime.now();
    }
}
