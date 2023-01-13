package com.learning.restclient.services.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    @Value("${service.url}")
    private String userService;
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Bean
    RestTemplate restTemplate() {
        return restTemplateBuilder.rootUri(userService).build();
    }
}
