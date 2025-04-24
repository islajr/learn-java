package org.project.todoapp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserLoginDTO(

        @NotBlank(message = "Email cannot be blank")
        @NotNull(message = "Email cannot be null")
        @Email(message = "Please provide a valid email")
        String email,

        @NotBlank(message = "Password cannot be blank")
        @NotNull(message = "Password cannot be null")
        String password
) {

    public UserLoginDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
