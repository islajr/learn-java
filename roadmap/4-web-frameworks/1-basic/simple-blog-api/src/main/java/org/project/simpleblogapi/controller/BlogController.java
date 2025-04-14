package org.project.simpleblogapi.controller;

import org.project.simpleblogapi.BlogPostDTO;
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
    public ResponseEntity<BlogPostDTO> createPost(@RequestBody BlogPostDTO blogPostDTO) {
        return blogService.createPost(blogPostDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<List<BlogPostDTO>> getPosts() {
        return blogService.getPosts();
    }

    @GetMapping()
    public ResponseEntity<BlogPostDTO> getPost(@RequestParam Long id) {
        return blogService.getPost(id);
    }

    @PutMapping()
    public ResponseEntity<BlogPostDTO> updatePost(@RequestParam (defaultValue = "0") Long id, @RequestBody BlogPostDTO blogPostDTO) {
        return blogService.updatePost(id, blogPostDTO);
    }

    @DeleteMapping()
    public ResponseEntity<String> deletePost(@RequestParam Long id) {
        return blogService.deletePost(id);
    }
}
