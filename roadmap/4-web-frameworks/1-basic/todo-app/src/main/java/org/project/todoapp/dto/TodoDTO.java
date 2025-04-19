package org.project.todoapp.dto;

import org.project.todoapp.model.Todo;

public record TodoDTO(
        Long id,
        String title,
        String description
) {
    public TodoDTO(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public TodoDTO(String title, String description) {
        this(null, title, description);
    }

    public TodoDTO(String placeholder) {
        this(placeholder, "");
    }

    public static TodoDTO fromEntity(Todo todo) {
        return new TodoDTO(todo.getId(), todo.getTitle(), todo.getDescription());
    }

    public static Todo toEntity(TodoDTO todoDTO) {
        return new Todo(todoDTO.id(), todoDTO.title(), todoDTO.description());
    }
}
