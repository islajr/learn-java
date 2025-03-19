package org.project.simpleblogapi.service;

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
        return blogRepository.save(blogPost);
    }

    public List<BlogPost> getPosts() {
        return blogRepository.findAll();
    }

    public Optional<BlogPost> getPost(Long id) {
        return blogRepository.findById(id);
    }

    public BlogPost updatePost(Long id, BlogPost blogPost) {
        Optional<BlogPost> formerPost = blogRepository.findById(id);

        if (formerPost.isPresent()) {
            blogRepository.save(blogPost);
            return blogPost;
        }
        throw new RuntimeException("No user with such id!");
    }

    public void deletePost(Long id) {
        blogRepository.deleteById(id);
    }
}
