package com.chat.entities;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Request {
    private  String sender;
    private String roomId;
    private String content;
    private LocalDateTime messageTime;

}
