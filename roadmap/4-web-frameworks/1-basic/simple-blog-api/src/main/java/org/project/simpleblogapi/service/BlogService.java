package org.project.simpleblogapi.service;

import org.project.simpleblogapi.exception.exceptions.PostDoesNotExistException;
import org.project.simpleblogapi.model.BlogPost;
import org.project.simpleblogapi.repository.BlogRepository;
import org.project.simpleblogapi.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BlogService {

    private final BlogRepository blogRepository;
    private final UserRepository userRepository;

    public BlogService(BlogRepository blogRepository, UserRepository userRepository) {
        this.blogRepository = blogRepository;
        this.userRepository = userRepository;
    }


    public ResponseEntity<BlogPost> createPost(BlogPost blogPost) {
        blogPost.setUser(userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()));  // handle this properly later
        blogPost.setCreatedAt(LocalDateTime.now());
        blogPost.setUpdatedAt(LocalDateTime.now());

        blogRepository.save(blogPost);
        return ResponseEntity.status(HttpStatus.CREATED).body(blogPost);
    }

    public ResponseEntity<List<BlogPost>> getPosts() {
        return ResponseEntity.ok(blogRepository.findAll());
    }

    public ResponseEntity<BlogPost> getPost(Long id) {
        BlogPost post = blogRepository.findById(id).orElseThrow(() -> new PostDoesNotExistException("Said post does not exist"));
        return ResponseEntity.ok(post);
    }

    public ResponseEntity<BlogPost> updatePost(Long id, BlogPost blogPost) {
        BlogPost formerPost = blogRepository.findById(id).orElseThrow(
                () -> new PostDoesNotExistException("There is no such post!"));

        if (blogPost.getTitle() != null && !blogPost.getTitle().isEmpty() && !blogPost.getTitle().equals(formerPost.getTitle())) {
            formerPost.setTitle(blogPost.getTitle());
        }

        if (blogPost.getCategory() != null && !blogPost.getCategory().isEmpty() && !blogPost.getCategory().equals(formerPost.getCategory())) {
            formerPost.setCategory(blogPost.getCategory());
        }

        if (blogPost.getContent() != null && !blogPost.getContent().isEmpty() && !blogPost.getContent().equals(formerPost.getContent())) {
            formerPost.setContent(blogPost.getContent());
        }

        formerPost.setUpdatedAt(LocalDateTime.now());
        blogRepository.save(formerPost);
        return ResponseEntity.ok(formerPost);
    }

    public ResponseEntity<String> deletePost(Long id) {
        try {
            blogRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
        } catch (PostDoesNotExistException e) {
            throw new PostDoesNotExistException("Cannot delete non-existent post.");
        }

    }
}
