package com.amigoscode;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

//references https://dzone.com/articles/circular-dependencies-jackson
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class MessageResponse {
    private static int identity = 1;
    public String response;
    public int id;
    public MessageResponse2 messageResponse2;

    public MessageResponse(String response) {
        this.id = 123;
        this.response = response;
        messageResponse2 = new MessageResponse2(response + "2", this);
    }
}

@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
class MessageResponse2 {
    private static int identity = 1;
    public String response;
    public int id;
    public MessageResponse messageResponse;

    public MessageResponse2(String response, MessageResponse messageResponse) {
        this.id = 87;
        this.response = response;
        this.messageResponse = messageResponse;
    }
}
