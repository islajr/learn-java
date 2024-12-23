package com.demo.student1.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/")
    public String hello() {
        return "Hello, Isla!";
    }
}
