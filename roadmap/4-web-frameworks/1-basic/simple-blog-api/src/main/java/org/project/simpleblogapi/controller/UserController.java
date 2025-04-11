package org.project.simpleblogapi.controller;

import org.project.simpleblogapi.model.User;
import org.project.simpleblogapi.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/blog/api/user")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public void register(@RequestBody User user) {
        userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return userService.login(user);
    }


}
