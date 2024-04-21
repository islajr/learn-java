package com.spring.crash;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrashController {

    @GetMapping("/")
    public String hello() {
        return "Hello, world!";
    }
}
