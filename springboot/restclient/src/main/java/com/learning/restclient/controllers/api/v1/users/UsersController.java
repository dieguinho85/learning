package com.learning.restclient.controllers.api.v1.users;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UsersController {
    @GetMapping("/{id}")
    public User show(@PathVariable("id") int id) {
        return new User(id, "user name", 25, "user.name@email.com");
    }

    @GetMapping
    public List<User> index() {
        return List.of(new User("Juan José", 25, "user.name@email.com"),
                        new User("Paola Cortés", 29, "paola.cortes@email.com"));
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return user;
    }

    @PutMapping("/{id}")
    public User update(@PathVariable("id") int id, @RequestBody User user) {
        user.setId(id);

        return user;
    }

    @DeleteMapping("/{id}")
    public User delete(@PathVariable("id") int id) {
        return null;
    }
}
