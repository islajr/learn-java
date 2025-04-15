package org.project.simpleblogapi.service;

import org.project.simpleblogapi.BlogPostDTO;
import org.project.simpleblogapi.exception.exceptions.PostDoesNotExistException;
import org.project.simpleblogapi.model.BlogPost;
import org.project.simpleblogapi.repository.BlogRepository;
import org.project.simpleblogapi.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService {

    private final BlogRepository blogRepository;
    private final UserRepository userRepository;

    public BlogService(BlogRepository blogRepository, UserRepository userRepository) {
        this.blogRepository = blogRepository;
        this.userRepository = userRepository;
    }


    public ResponseEntity<BlogPostDTO> createPost(BlogPostDTO blogPostDTO) {

        BlogPost blogPost = BlogPostDTO.toEntity(blogPostDTO);

        blogPost.setUser(userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()));  // handle this properly later
        blogPost.setCreatedAt(LocalDateTime.now());
        blogPost.setUpdatedAt(LocalDateTime.now());

        blogRepository.save(blogPost);
        return ResponseEntity.status(HttpStatus.CREATED).body(BlogPostDTO.fromEntity(blogPost));
    }

    public ResponseEntity<List<BlogPostDTO>> getPosts() {
        List<BlogPost> posts = blogRepository.findAll();
        List<BlogPostDTO> postDTOS = new ArrayList<>();

        for (BlogPost post : posts) {

            if (isPostForUser(post, SecurityContextHolder.getContext().getAuthentication().getName()))
                postDTOS.add(BlogPostDTO.fromEntity(post));
        }

        return ResponseEntity.ok(postDTOS);
    }

    public ResponseEntity<BlogPostDTO> getPost(Long id) {
        BlogPost post = blogRepository.findById(id).orElseThrow(() -> new PostDoesNotExistException("Said post does not exist"));

        if (isPostForUser(post, SecurityContextHolder.getContext().getAuthentication().getName()))
            return ResponseEntity.ok(BlogPostDTO.fromEntity(post));

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
    }

    public ResponseEntity<BlogPostDTO> updatePost(Long id, BlogPostDTO blogPostDTO) {
        BlogPost formerPost = blogRepository.findById(id).orElseThrow(
                () -> new PostDoesNotExistException("There is no such post!"));

        if (!isPostForUser(formerPost, SecurityContextHolder.getContext().getAuthentication().getName()))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);

        BlogPost blogPost = BlogPostDTO.toEntity(blogPostDTO);

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
        return ResponseEntity.ok(BlogPostDTO.fromEntity(formerPost));
    }

    public ResponseEntity<String> deletePost(Long id) {

        // check if post belongs to user
        BlogPost post = blogRepository.findById(id).orElseThrow(
                () -> new PostDoesNotExistException("There is no such post!"));

        if (!isPostForUser(post, SecurityContextHolder.getContext().getAuthentication().getName()))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("You cannot delete this post!");


        try {
            blogRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
        } catch (PostDoesNotExistException e) {
            throw new PostDoesNotExistException("Cannot delete non-existent post.");
        }

    }

    private boolean isPostForUser(BlogPost blogPost, String username) {
        return (blogPost.getUser().getUsername().equals(username));
    }
}
