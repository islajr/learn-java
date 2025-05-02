package org.project.todoapp.dto;

public record TodoUpdateDTO(
        String title,
        String description,
        String status
) {
    public TodoUpdateDTO(String title, String description, String status) {
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public TodoUpdateDTO(String title, String description) {
        this(title, description, "");
    }

    public TodoUpdateDTO(String status) {
        this("", "", status);
    }
}
