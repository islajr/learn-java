package org.project.todoapp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.project.todoapp.model.User;

public record UserDTO(

        @NotNull(message = "Name field cannot be null")
        @NotBlank(message = "Name field cannot be blank")
        String name,

        @NotBlank(message = "Email field cannot be blank")
        @NotNull(message = "Email field cannot be null")
        @Email(message = "Please provide a valid email")
        String email,

        @NotNull(message = "Password field cannot be null")
        @NotBlank(message = "Password field cannot be blank")
        String password
        ) {

    // all-arg constructor
    public UserDTO(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public static UserDTO fromEntity(User user) {
        return new UserDTO(user.getName(), user.getEmail(), user.getPassword());
    }

    public static User toEntity(UserDTO userDTO) {
        return new User(
                userDTO.name(), userDTO.email(), userDTO.password());
    }
}
