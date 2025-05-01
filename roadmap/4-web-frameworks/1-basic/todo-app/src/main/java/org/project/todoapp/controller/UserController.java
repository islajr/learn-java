package org.project.todoapp.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.project.todoapp.dto.UserDTO;
import org.project.todoapp.dto.UserLoginDTO;
import org.project.todoapp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/todo/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid UserDTO userDTO) {
        return userService.register(userDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid UserLoginDTO userloginDTO) {
        return userService.login(userloginDTO);
    }

    @PostMapping("/refresh")
    public ResponseEntity<String> refresh(@RequestBody String refreshToken) {
        return userService.refresh(refreshToken);
    }


    /* fix jwt invalid signature issue */
    /* more security features - complete amigoscode security video */
    /* refresh token, unit testing, filtering and sorting */
}
