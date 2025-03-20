package org.project.simpleblogapi.controller;

import org.project.simpleblogapi.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/blogapi/user")
@RestController
public class UserController {

    @PostMapping("/register")
    public void register(@RequestBody User user) {

    }
}
