package org.project.todoapp.controller;

import lombok.AllArgsConstructor;
import org.project.todoapp.model.Todo;
import org.project.todoapp.repository.TodoRepository;
import org.project.todoapp.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/todo")
public class TodoController {

    private final TodoService todoService;

    @PostMapping("")
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
        return todoService.createTodo(todo);
    }

    @PutMapping("")
    public ResponseEntity<Todo> updateTodo(@RequestParam Long id, @RequestBody Todo todo) {
        return todoService.updateTodo(id, todo);
    }

    @DeleteMapping("")
    public ResponseStatus deleteTodo(@RequestParam Long id) {
        return todoService.deleteTodo(id);
    }
}
