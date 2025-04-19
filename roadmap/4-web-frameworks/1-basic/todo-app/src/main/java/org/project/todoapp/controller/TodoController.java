package org.project.todoapp.controller;

import lombok.AllArgsConstructor;
import org.project.todoapp.dto.TodoDTO;
import org.project.todoapp.model.Todo;
import org.project.todoapp.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/todo")
public class TodoController {

    private final TodoService todoService;

    @PostMapping("")
    public ResponseEntity<TodoDTO> createTodo(@RequestBody Todo todo) {
        return todoService.createTodo(todo);
    }

    @PutMapping("")
    public ResponseEntity<TodoDTO> updateTodo(@RequestParam Long id, @RequestBody Todo todo) {
        return todoService.updateTodo(id, todo);
    }

    @DeleteMapping("")
    public ResponseStatus deleteTodo(@RequestParam Long id) {
        return todoService.deleteTodo(id);
    }
}
