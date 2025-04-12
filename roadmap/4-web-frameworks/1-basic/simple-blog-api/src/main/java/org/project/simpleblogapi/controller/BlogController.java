package org.project.simpleblogapi.controller;

import org.project.simpleblogapi.model.BlogPost;
import org.project.simpleblogapi.service.BlogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog/api/post")
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping()
    public ResponseEntity<BlogPost> createPost(@RequestBody BlogPost blogPost) {
        return blogService.createPost(blogPost);
    }

    @GetMapping("/all")
    public ResponseEntity<List<BlogPost>> getPosts() {
        return blogService.getPosts();
    }

    @GetMapping()
    public ResponseEntity<BlogPost> getPost(@RequestParam Long id) {
        return blogService.getPost(id);
    }

    @PutMapping()
    public ResponseEntity<BlogPost> updatePost(@RequestParam (defaultValue = "0") Long id, @RequestBody BlogPost blogPost) {
        return blogService.updatePost(id, blogPost);
    }

    @DeleteMapping()
    public ResponseEntity<String> deletePost(@RequestParam Long id) {
        return blogService.deletePost(id);
    }
}
