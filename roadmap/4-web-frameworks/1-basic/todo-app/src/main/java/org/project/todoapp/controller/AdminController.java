package org.project.todoapp.controller;

import lombok.AllArgsConstructor;
import org.project.todoapp.model.Todo;
import org.project.todoapp.model.User;
import org.project.todoapp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/admin/api/todo")
public class AdminController {

    private final UserService userService;

    @DeleteMapping("/user")
    public ResponseEntity<String> deleteUser(@RequestParam Long id) {
        return userService.deleteUser(id);
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos() {
        return userService.getAllTodos();
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> getAllUsers() {
        return userService.getAllUsers();
    }

}
