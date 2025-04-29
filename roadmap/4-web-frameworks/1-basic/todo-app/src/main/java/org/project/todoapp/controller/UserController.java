package org.project.todoapp.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.project.todoapp.dto.UserDTO;
import org.project.todoapp.dto.UserLoginDTO;
import org.project.todoapp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    /* fix jwt invalid signature issue */
    /* ensure that each user's todos are independent of one another */
    /* implement pagination, rate-limiting, etc */
    /* more security features - complete amigoscode security video */
    /* complete get method */
    /* refresh token, unit testing, filtering and sorting */
    /* proper custom error handling */
}
