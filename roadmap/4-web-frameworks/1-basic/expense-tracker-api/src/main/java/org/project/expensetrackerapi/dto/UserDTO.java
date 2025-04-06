package org.project.expensetrackerapi.dto;

import jakarta.validation.constraints.NotBlank;
import org.project.expensetrackerapi.model.User;

public record UserDTO(

        @NotBlank(message = "Username is required")
        String username,

        @NotBlank(message = "Password is required")
        String password
) {

    public static UserDTO fromEntity(User user) {
        return new UserDTO(user.getUsername(), user.getPassword());
    }

    public static User toEntity(UserDTO userDTO) {
        return new User(userDTO.username(), userDTO.password());
    }
}
