package org.project.todoapp.controller;

import lombok.AllArgsConstructor;
import org.project.todoapp.model.Todo;
import org.project.todoapp.model.User;
import org.project.todoapp.service.UserService;
import org.springframework.data.domain.Page;
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
    public ResponseEntity<Page<Todo>> getAllTodos() {
        return userService.getAllTodos();
    }

}
