package com.spring.crash;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CrashController {

    private List<Photo> db = List.of(new Photo("1", "hello.jpg"));

    @GetMapping("/")
    public String hello() {
        return "Hello, world!";
    }

    @GetMapping("/photos")
    public List<Photo> get() {
        return db;
    }
}
