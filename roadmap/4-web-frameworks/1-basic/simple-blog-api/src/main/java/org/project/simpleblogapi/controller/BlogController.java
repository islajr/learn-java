package org.project.simpleblogapi.controller;

import org.project.simpleblogapi.model.BlogPost;
import org.project.simpleblogapi.service.BlogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/blogapi/post")
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping()
    public BlogPost createPost(@RequestBody BlogPost blogPost) {
        return blogService.createPost(blogPost);
    }

    @GetMapping()
    public List<BlogPost> getPosts() {
        return blogService.getPosts();
    }

    @GetMapping("/{id}")
    public Optional<BlogPost> getPost(@PathVariable Long id) {
        return blogService.getPost(id);
    }

    @PutMapping("/{id}")
    public BlogPost updatePost(@PathVariable Long id, @RequestBody BlogPost blogPost) {
        return blogService.updatePost(id, blogPost);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        blogService.deletePost(id);
    }
}
