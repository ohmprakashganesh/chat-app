package com.chat.exception;

public class AlreadyExist  extends  RuntimeException{
    public AlreadyExist(String msg){
        super(msg);
    }
}
