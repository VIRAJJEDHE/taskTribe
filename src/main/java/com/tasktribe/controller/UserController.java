package com.tasktribe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tasktribe.entity.User;
import com.tasktribe.service.UserService;


@RestController
public class UserController {
    
    @Autowired
    private UserService userService;
    @PostMapping("/register-user")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        if(userService.login(user)) {
            return "Logged in Successfully";
        }
        return "Login Failed";
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
