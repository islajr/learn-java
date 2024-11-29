package com.example.student.student.api;

import com.example.student.student.model.user;
import com.example.student.student.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student/user/")
public class userController {

    @Autowired
    private userService _userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody user _user) {
        return _userService.registerUser(_user);
    }

    @PostMapping("/login")
    public String login(@RequestBody user _user) {
        return "nothing";
    }
}
