package com.example.security_demo.controller;

import com.example.security_demo.model.User;
import com.example.security_demo.service.UsersService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/security")
@RestController
public class UserController {

    private final UsersService usersService;

    @Autowired
    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/greet")
    public String greet() {
        return "<h1>Hello, Stranger! </h1>";
    }

    @GetMapping("/csrf")
    public CsrfToken getCsrf(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/createUser")
    public String createUser(@RequestBody User user) {
        return UsersService.createUser(user);
    }

}
