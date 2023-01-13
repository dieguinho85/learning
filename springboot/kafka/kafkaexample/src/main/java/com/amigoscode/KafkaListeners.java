package com.amigoscode;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class KafkaListeners {

    @Value("${spring.kafka.boostrap-servers}")
    public String boostrapServers;

    @KafkaListener(
            topics = "myFirstTopic",
            groupId = "groupId"
    )
    void listener(String data) {
        System.out.println("Listener received: \"" + data + "\" from myFirstTopic");
    }
}

