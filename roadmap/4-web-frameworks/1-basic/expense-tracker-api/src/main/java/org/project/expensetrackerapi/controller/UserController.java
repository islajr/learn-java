package org.project.expensetrackerapi.controller;

import lombok.AllArgsConstructor;
import org.project.expensetrackerapi.dto.UserDTO;
import org.project.expensetrackerapi.model.User;
import org.project.expensetrackerapi.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user/")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDTO userDTO) {
        return userService.register(userDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDTO userDTO) {
        return userService.login(userDTO);
    }
}
