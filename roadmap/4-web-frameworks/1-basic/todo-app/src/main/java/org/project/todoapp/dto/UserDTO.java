package org.project.todoapp.dto;

import org.project.todoapp.model.User;

public record UserDTO(
        String name,
        String email,
        String password
        ) {

    // all-arg constructor
    public UserDTO(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public UserDTO(String email, String password) {
        this("", email, password);
    }

   /* public static UserDTO fromEntity(User user) {
        return new UserDTO(user.getName(), user.getEmail(), user.getPassword());
    }*/

    public static User toEntity(UserDTO userDTO) {
        return new User(
                userDTO.name(), userDTO.email(), userDTO.password());
    }
}
