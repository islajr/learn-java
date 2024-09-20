package com.example.security_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/security/greet")
    public String greet() {
        return "<h1>Hello, Stranger! </h1>";
    }
}
