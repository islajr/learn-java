package org.project.simpleblogapi.service;

import org.project.simpleblogapi.exception.PostDoesNotExistException;
import org.project.simpleblogapi.model.BlogPost;
import org.project.simpleblogapi.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }


    public BlogPost createPost(BlogPost blogPost) {
        blogPost.setCreatedAt(LocalDateTime.now());
        blogPost.setUpdatedAt(LocalDateTime.now());

        return blogRepository.save(blogPost);
    }

    public List<BlogPost> getPosts() {
        return blogRepository.findAll();
    }

    public Optional<BlogPost> getPost(Long id) {
        Optional<BlogPost> post = blogRepository.findById(id);

        if (post.isPresent()) {
            return post;
        } else {
            throw new RuntimeException("There is no such post!");
        }
    }

    public BlogPost updatePost(Long id, BlogPost blogPost) {
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
        return formerPost;
    }

    public void deletePost(Long id) {
        try {
            blogRepository.deleteById(id);
        } catch (PostDoesNotExistException e) {
            throw new PostDoesNotExistException("Cannot delete non-existent post.");
        }

    }
}
