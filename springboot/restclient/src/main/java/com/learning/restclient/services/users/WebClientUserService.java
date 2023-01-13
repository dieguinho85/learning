package com.learning.restclient.services.users;

import com.learning.restclient.controllers.api.v3.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class WebClientUserService {
    @Autowired
    WebClient webClient;

    private final String USER_URL = "/users";

    public User show(int id) {
        Mono<User> request = webClient.get().uri(USER_URL + "/" + id).retrieve().bodyToMono(User.class);
        User user = request.block();
        return user;
    }

    public List<User> index() {
        Flux<User> request = webClient.get().uri(USER_URL).retrieve().bodyToFlux(User.class);
        List<User> users = request.collectList().block();

        return users;
    }

    public User create(User user) {
        Mono<User> request = webClient
                .post()
                .uri(USER_URL)
                .body(Mono.just(user), User.class)
                .retrieve()
                .bodyToMono(User.class);

        user = request.block();

        return user;
    }

    public User update(int id, User user) {
        Mono<User> just = Mono.just(user);

        Mono<User> request = webClient
                .put()
                .uri(USER_URL + "/" + id)
                .body(Mono.just(user), User.class)
                .retrieve()
                .bodyToMono(User.class);

        user = request.block();

        return user;
    }

    public User delete(int id) {
        Mono<User> request = webClient
                .delete()
                .uri(USER_URL + "/" + id)
                .retrieve()
                .bodyToMono(User.class);

        User user = request.block();

        return user;
    }
}
