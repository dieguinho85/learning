package com.learning.restclient.services.users;

import com.learning.restclient.controllers.api.v2.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RestTemplateUserService {
    @Autowired
    private RestTemplate restTemplate;

    private final String USER_URL = "/users";

    public User show(int id) {
        return restTemplate.getForObject(String.format("/%s/%d", USER_URL, id), User.class);
    }

    public List<User> index() {
        return restTemplate.getForObject(USER_URL, List.class);
    }

    public User create(User user) {
        return restTemplate.exchange(USER_URL, HttpMethod.POST, new HttpEntity<>(user), User.class).getBody();
    }

    public User update(int id, User user) {
        return restTemplate.exchange(String.format("/%s/%d", USER_URL, id), HttpMethod.PUT, new HttpEntity<>(user), User.class).getBody();
    }

    public User delete(int id) {
        return restTemplate.exchange(String.format("/%s/%d", USER_URL, id), HttpMethod.DELETE, null, User.class).getBody();
    }
}
