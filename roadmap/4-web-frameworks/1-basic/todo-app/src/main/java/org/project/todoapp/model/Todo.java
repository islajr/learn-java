package org.project.todoapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Todo {

    @Id
    private Long id;
    private String title;
    private String description;
    @ManyToOne
    private User user;

    public Todo(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }
}
