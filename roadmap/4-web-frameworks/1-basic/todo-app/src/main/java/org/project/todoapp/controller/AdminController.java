package org.project.todoapp.controller;

import lombok.AllArgsConstructor;
import org.project.todoapp.dto.TodoDTO;
import org.project.todoapp.model.Todo;
import org.project.todoapp.service.TodoService;
import org.project.todoapp.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/admin/api/todo")
public class AdminController {

    private final UserService userService;
    private final TodoService todoService;

    @DeleteMapping("/user")
    public ResponseEntity<String> deleteUser(@RequestParam Long id) {
        return userService.deleteUser(id);
    }

    @GetMapping
    public ResponseEntity<Page<TodoDTO>> getAllTodos(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        return todoService.getAllTodos(page, size, sortBy);
    }

}
