package org.project.todoapp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.project.todoapp.model.Role;
import org.project.todoapp.model.User;

public record UserDTO(

        String name,

        @NotBlank(message = "Email field cannot be blank")
        @NotNull(message = "Email field cannot be null")
        @Email(message = "Please provide a valid email")
        String email,

        @NotNull(message = "Password field cannot be null")
        @NotBlank(message = "Password field cannot be blank")
        String password,

        @NotNull(message = "Role cannot be null")
        @NotBlank(message = "Role cannot be blank")
        String role
        ) {

    // all-arg constructor
    public UserDTO(String name, String email, String password, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public static UserDTO fromEntity(User user) {
        return new UserDTO(user.getName(), user.getEmail(), user.getPassword(), user.getRole().name());
    }

    public static User toEntity(UserDTO userDTO) {
        return new User(
                userDTO.name(), userDTO.email(), userDTO.password(), toRole(userDTO.role()), userDTO.role());
    }

    private static Role toRole(String role) {
        if (role.trim().equalsIgnoreCase("USER")) {
            return Role.USER;
        } else if (role.trim().equalsIgnoreCase("ADMIN")) {
            return Role.ADMIN;
        } return null;
    }
}
