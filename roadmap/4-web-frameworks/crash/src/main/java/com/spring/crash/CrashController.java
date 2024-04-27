package com.spring.crash;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.Collection;
import java.util.UUID;

@RestController
public class CrashController {

    private final PhotosService photosService;

    public CrashController(PhotosService photosService) {
        this.photosService = photosService;
    }


    @GetMapping("/")
    public String hello() {
        return "Hello, world!";
    }

    @GetMapping("/photos")
    public Collection<Photo> getAllPhotos() {
        return photosService.get();
    }

    @GetMapping("/photos/{id}")
    public Photo getPhoto(@PathVariable String id) {
        Photo photo = photosService.get(id);
        if (photo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        else {
            return photo;
        }
    }

    @DeleteMapping("/photos/{id}")
    public void deletePhoto(@PathVariable String id) {
        Photo photo = photosService.remove(id);

        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/photos/create")
    public Photo createPhoto(@RequestPart("data") MultipartFile file) throws IOException {
        Photo photo = new Photo();
        photo.setId(UUID.randomUUID().toString());
        photo.setName(file.getOriginalFilename());
        photo.setData(file.getBytes());
        photosService.save(photo.getId(), photo);
        return photo;
    }
}
