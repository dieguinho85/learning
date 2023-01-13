package com.amigoscode;

//public record MessageRequest(String Message) {}

import org.springframework.lang.NonNull;

public class MessageRequest {
    private String myMessage;

    @NonNull
    public String getMyMessage() {
        return myMessage;
    }
}