package org.project.simpleblogapi;

import org.project.simpleblogapi.model.BlogPost;

import java.util.ArrayList;

public record BlogPostDTO(
    String title,
    String content,
    String category,
    ArrayList<String> tags
) {

    public BlogPostDTO(String title, String content, String category, ArrayList<String> tags) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.tags = tags;
    }

    public static BlogPost toEntity(BlogPostDTO blogPostDTO) {
        return new BlogPost(
                blogPostDTO.title(), blogPostDTO.content(), blogPostDTO.category(), blogPostDTO.tags()
        );
    }

    public static BlogPostDTO fromEntity(BlogPost blogPost) {
        return new BlogPostDTO(blogPost.getTitle(), blogPost.getContent(), blogPost.getCategory(), blogPost.getTags());
    }
}
