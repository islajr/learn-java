package org.project.todoapp.controller;

import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.project.todoapp.dto.TodoDTO;
import org.project.todoapp.dto.TodoUpdateDTO;
import org.project.todoapp.service.TodoService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/todo")
public class TodoController {

    private final TodoService todoService;

    @PostMapping("")
    public ResponseEntity<TodoDTO> createTodo(@RequestBody TodoDTO todoDTO) {
        return todoService.createTodo(todoDTO);
    }

    @PutMapping("")
    public ResponseEntity<TodoDTO> updateTodo(@RequestParam Long id, @RequestBody TodoUpdateDTO updateDTO) {
        return todoService.updateTodo(id, updateDTO);
    }

    @DeleteMapping("")
    public ResponseEntity<String> deleteTodo(@RequestParam Long id) {
        return todoService.deleteTodo(id);
    }

    @GetMapping("")
    public ResponseEntity<Page<TodoDTO>> getTodos(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        return todoService.getTodos(page, size);
    }
}
