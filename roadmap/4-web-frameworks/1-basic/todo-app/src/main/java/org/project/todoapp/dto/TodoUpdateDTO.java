package org.project.todoapp.dto;

public record TodoUpdateDTO(
        String title,
        String description
) {
    public TodoUpdateDTO(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
