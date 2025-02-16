package com.tasktribe.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Value;



@RestController
public class helloController {

    @Value("${welcome.message}")
    String WelcomeMessage;

    @GetMapping("/")
    public String getMethodName() {
        return WelcomeMessage;
    }
    
    
}
