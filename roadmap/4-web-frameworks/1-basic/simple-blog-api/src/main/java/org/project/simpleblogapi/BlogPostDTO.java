package org.project.simpleblogapi;

import org.project.simpleblogapi.model.BlogPost;

public record BlogPostDTO(
    String title,
    String content,
    String category

) {

    public BlogPostDTO(String title, String content, String category) {
        this.title = title;
        this.content = content;
        this.category = category;
    }

    public static BlogPost toEntity(BlogPostDTO blogPostDTO) {
        return new BlogPost(
                blogPostDTO.title(), blogPostDTO.content(), blogPostDTO.category()
        );
    }

    public static BlogPostDTO fromEntity(BlogPost blogPost) {
        return new BlogPostDTO(blogPost.getTitle(), blogPost.getContent(), blogPost.getCategory());
    }
}
