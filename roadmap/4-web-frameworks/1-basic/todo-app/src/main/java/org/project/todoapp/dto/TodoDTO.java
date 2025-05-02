package org.project.todoapp.dto;

import org.project.todoapp.model.Status;
import org.project.todoapp.model.Todo;

public record TodoDTO(
        Long id,
        String title,
        String description,
        String status
) {
    public TodoDTO(Long id, String title, String description, String status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    /*public TodoDTO(String title, String description) {
        this(null, title, description);
    }*/

    // for updating title or description
    public TodoDTO(String title, String description) {
        this(0L, title, description, null);
    }

    public TodoDTO(String status) {
        this(0L, "", "", status);
    }

    public static TodoDTO fromEntity(Todo todo) {
        return new TodoDTO(todo.getId(), todo.getTitle(), todo.getDescription(), todo.getStatus().name());
    }

    public static Todo toEntity(TodoDTO todoDTO) {
        return new Todo(todoDTO.id(), todoDTO.title(), todoDTO.description(), Status.valueOf(todoDTO.status().toUpperCase().trim()));
    }
}
