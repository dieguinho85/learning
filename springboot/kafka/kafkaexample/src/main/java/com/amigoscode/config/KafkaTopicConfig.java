package com.amigoscode.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.Map;

@Configuration
public class KafkaTopicConfig {

    @Value("${spring.kafka.boostrap-servers}")
    public String boostrapServers;

    @Bean
    public NewTopic amigoscodeTopic() {
        return TopicBuilder.name("amigoscode2").build();
    }

    @Bean
    public NewTopic diegoTopic() {
        return TopicBuilder.name("diegoTopic").build();
    }

    @Bean
    public KafkaAdmin admin() {
        return new KafkaAdmin(Map.of(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, boostrapServers));
    }
}
