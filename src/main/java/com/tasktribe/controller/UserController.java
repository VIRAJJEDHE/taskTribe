package com.tasktribe.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tasktribe.entity.User;
import com.tasktribe.service.UserService;


@RestController
public class UserController {
    UserService userService;
    @PostMapping("/register-user")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/users/{Id}")
    public User getUserById(@PathVariable Long Id) {
        return userService.getUserById(Id);
    }
}
