package org.project.todoapp.controller;

import lombok.AllArgsConstructor;
import org.project.todoapp.model.Todo;
import org.project.todoapp.repository.TodoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/todo")
public class TodoController {

    private final TodoRepository todoRepository;

    @PostMapping("")
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
        return todoRepository.createTodo(todo);
    }

    @PutMapping("")
    public ResponseEntity<Todo> updateTodo(@RequestParam Long id, @RequestBody Todo todo) {
        return todoRepository.updateTodo(id, todo);
    }

    @DeleteMapping("")
    public ResponseStatus deleteTodo(@RequestParam Long id) {
        return todoRepository.deleteTodo(id);
    }
}
