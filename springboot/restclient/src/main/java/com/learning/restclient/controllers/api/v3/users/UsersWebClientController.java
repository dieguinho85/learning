package com.learning.restclient.controllers.api.v3.users;

import com.learning.restclient.services.users.WebClientUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v3/users")
public class UsersWebClientController {
    @Autowired
    WebClientUserService WebClientUserService;

    @GetMapping("/{id}")
    public User show(@PathVariable("id") int id) {
        return WebClientUserService.show(id);
    }

    @GetMapping
    public List<User> index() {
        return WebClientUserService.index();
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return WebClientUserService.create(user);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable("id") int id, @RequestBody User user) {
        return WebClientUserService.update(id, user);
    }

    @DeleteMapping("/{id}")
    public User delete(@PathVariable("id") int id) {
        return WebClientUserService.delete(id);
    }
}
