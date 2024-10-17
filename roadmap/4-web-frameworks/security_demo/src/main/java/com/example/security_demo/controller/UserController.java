package com.example.security_demo.controller;

import com.example.security_demo.model.User;
import com.example.security_demo.service.UsersService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/security/greet")
    public String greet() {
        return "<h1>Hello, Stranger! </h1>";
    }

    @GetMapping("/security/users")
    public String getUser() {
        return "This is a user!";
    }

    @GetMapping("/security/csrf")
    public CsrfToken getCsrf(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/security/createUser")
    public void createUser(@RequestBody User user) {
        UsersService.createUser(user);
    }
}
