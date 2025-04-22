package org.project.todoapp.service;

import lombok.AllArgsConstructor;
import org.project.todoapp.dto.TodoDTO;
import org.project.todoapp.model.Todo;
import org.project.todoapp.model.User;
import org.project.todoapp.model.UserPrincipal;
import org.project.todoapp.repository.TodoRepository;
import org.project.todoapp.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TodoService {

    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    public ResponseEntity<TodoDTO> createTodo(TodoDTO todoDTO) {
        Todo todo = TodoDTO.toEntity(todoDTO);

        if (todo.isValid()) {
            String email = ((UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getEmail();
            User user = userRepository.findByEmail(email);
            todo.setUser(user);
            todoRepository.save(todo);
            return ResponseEntity.status(HttpStatus.CREATED).body(TodoDTO.fromEntity(todo));
        } throw new RuntimeException("Input Error. Please fill all fields.");   // customize exception later.
    }

    public ResponseEntity<TodoDTO> updateTodo(Long id, TodoDTO todoDTO) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new RuntimeException("There is no item with this id!"));   // customize exception later

        if (!todo.belongsToUser())
            throw new RuntimeException("You are not authorized to do this");    // customize exception later.

        if (!todoDTO.title().isEmpty() && !todoDTO.title().equals(todo.getTitle())) {
            todo.setTitle(todoDTO.title());
        } if (!todoDTO.description().isEmpty() && !todoDTO.description().equals(todo.getDescription())) {
            todo.setDescription(todoDTO.description());
        }
        todoRepository.save(todo);
        return ResponseEntity.ok(TodoDTO.fromEntity(todo));

    }

    public ResponseEntity<String> deleteTodo(Long id) {

        Todo todo = todoRepository.findById(id).orElseThrow(() -> new RuntimeException("There is no item with this id!"));  // customize exception later

        if (!todo.belongsToUser())
            throw new RuntimeException("You are not authorized to do this");    // customize exception later

        todoRepository.deleteById(id);
        return ResponseEntity.status(204).body(null);

    }
}
