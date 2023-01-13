package com.amigoscode;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/message")
public class MessageController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private NewTopic diegoTopic;

    @PostMapping
    public MessageResponse publish(@RequestBody MessageRequest request) {
        kafkaTemplate.send("custom-topic", request.getMyMessage());
        kafkaTemplate.send(diegoTopic.name(), request.getMyMessage());

        return new MessageResponse("This is the response for message: " + request.getMyMessage());
    }
}
