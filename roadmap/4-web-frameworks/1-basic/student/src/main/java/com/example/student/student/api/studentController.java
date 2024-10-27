package com.example.student.student.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student/")
public class studentController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, Isaac! ";
    }
}
