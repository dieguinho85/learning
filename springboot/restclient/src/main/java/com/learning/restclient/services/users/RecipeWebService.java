package com.learning.restclient.services.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class RecipeWebService {
    @Value("${service.url}")
    private String userService;
    private final WebClient webClient;

    @Autowired
    public RecipeWebService(WebClient.Builder builder) {
        this.webClient = builder.baseUrl(userService).build();
    }
}
