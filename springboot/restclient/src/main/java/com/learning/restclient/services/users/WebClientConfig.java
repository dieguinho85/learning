package com.learning.restclient.services.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Value("${service.url}")
    private String userService;

    @Autowired
    WebClient.Builder builder;

    @Bean
    WebClient webClient() {
        return builder.baseUrl(userService).build();
    }
}
