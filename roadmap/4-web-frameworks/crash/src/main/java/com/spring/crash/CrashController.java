package com.spring.crash;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CrashController {

    private Map<String, Photo> db = new HashMap<>() {{
        put("1", new Photo("1", "hello.jpg"));
    }};


    @GetMapping("/")
    public String hello() {
        return "Hello, world!";
    }

    @GetMapping("/photos")
    public Collection<Photo> getAllPhotos() {
        return db.values();
    }

    @GetMapping("/photos/{id}")
    public Photo getPhoto(@PathVariable String id) {
        Photo photo = db.get(id);
        if (photo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        else {
            return photo;
        }
    }
}
