package org.project.simpleblogapi.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "blog_posts")
public class BlogPost {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    String title;
    String content;
    String category;

    @ElementCollection
    List<String> tags;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public BlogPost(String title, String content, String category, List<String> tags) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.tags = tags;
    }

}
