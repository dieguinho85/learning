package com.learning.restclient.controllers.api.v1.users;

import java.security.SecureRandom;

public class User {
    private static SecureRandom secureRandom = new SecureRandom();
    public Integer id;
    public String name;
    public int age;
    public String email;

    public User() {
        this.id = secureRandom.nextInt();
    }

    public User(String name, int age, String email) {
        this.id = secureRandom.nextInt();
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public User(Integer id, String name, int age, String email) {
        this.id = id == null ? secureRandom.nextInt() : id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public void setId(Integer id) {
        this.id = id == null ? secureRandom.nextInt() : id;
    }
}
