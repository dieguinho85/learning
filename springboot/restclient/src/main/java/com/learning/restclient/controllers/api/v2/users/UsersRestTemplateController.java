package com.learning.restclient.controllers.api.v2.users;

import com.learning.restclient.services.users.RestTemplateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v2/users")
public class UsersRestTemplateController {
    @Autowired
    RestTemplateUserService restTemplateUserService;

    @GetMapping("/{id}")
    public User show(@PathVariable("id") int id) {
        return restTemplateUserService.show(id);
    }

    @GetMapping
    public List<User> index() {
        return restTemplateUserService.index();
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return restTemplateUserService.create(user);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable("id") int id, @RequestBody User user) {
        return restTemplateUserService.update(id, user);
    }

    @DeleteMapping("/{id}")
    public User delete(@PathVariable("id") int id) {
        return restTemplateUserService.delete(id);
    }
}
