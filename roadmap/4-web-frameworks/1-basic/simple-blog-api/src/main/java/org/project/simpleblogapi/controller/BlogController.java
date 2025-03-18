package org.project.simpleblogapi.controller;

import org.project.simpleblogapi.model.BlogPost;
import org.project.simpleblogapi.service.BlogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping()
    public BlogPost createPost(@RequestBody BlogPost) {
        return blogService.createPost();
    }

    @GetMapping()
    public List<BlogPost> getPosts() {
        return blogService.getPosts();
    }

    @GetMapping("/{id}")
    public BlogPost getPost(@PathVariable Long id) {
        return blogService.getPost();
    }

    @PutMapping("/{id}")
    public BlogPost updatePost(@PathVariable Long id) {
        return blogService.updatePost();
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        blogService.deletePost();
    }
}
