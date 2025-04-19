package org.project.todoapp.service;

import org.project.todoapp.dto.TodoDTO;
import org.project.todoapp.model.Todo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

@Service
public class TodoService {

    public ResponseEntity<TodoDTO> createTodo(Todo todo) {
    }

    public ResponseEntity<TodoDTO> updateTodo(Long id, Todo todo) {
    }

    public ResponseStatus deleteTodo(Long id) {
    }
}
