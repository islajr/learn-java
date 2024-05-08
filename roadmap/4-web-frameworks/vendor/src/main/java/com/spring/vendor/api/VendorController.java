package com.spring.vendor.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendorController {

    @GetMapping("/")
    public String hello() {
        return "Hello, world!\nWelcome to Cloud Vendor";
    }
}
