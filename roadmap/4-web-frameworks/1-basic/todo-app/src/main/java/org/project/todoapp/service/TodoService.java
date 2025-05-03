package org.project.todoapp.service;

import lombok.AllArgsConstructor;
import org.project.todoapp.dto.TodoDTO;
import org.project.todoapp.dto.TodoUpdateDTO;
import org.project.todoapp.exception.exceptions.InvalidCredentialsException;
import org.project.todoapp.exception.exceptions.UnauthorizedException;
import org.project.todoapp.exception.exceptions.UserNotFoundException;
import org.project.todoapp.model.Status;
import org.project.todoapp.model.Todo;
import org.project.todoapp.model.User;
import org.project.todoapp.model.UserPrincipal;
import org.project.todoapp.repository.TodoRepository;
import org.project.todoapp.repository.UserRepository;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        } throw new InvalidCredentialsException("Input Error. Please fill all fields.");
    }

    public ResponseEntity<TodoDTO> updateTodo(Long id, TodoUpdateDTO updateDTO) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new UserNotFoundException("There is no item with this id!"));

        if (!todo.belongsToUser())
            throw new UnauthorizedException("You do not have access to this todo.");

        if (!updateDTO.title().isEmpty() && !updateDTO.title().equals(todo.getTitle())) {
            todo.setTitle(updateDTO.title());
        } if (!updateDTO.description().isEmpty() && !updateDTO.description().equals(todo.getDescription())) {
            todo.setDescription(updateDTO.description());
        } if (!updateDTO.status().isEmpty() && !updateDTO.status().equals(todo.getStatus().name())) {
            todo.setStatus(Status.valueOf(updateDTO.status()));
        }
        todoRepository.save(todo);
        return ResponseEntity.ok(TodoDTO.fromEntity(todo));

    }

    public ResponseEntity<String> deleteTodo(Long id) {

        Todo todo = todoRepository.findById(id).orElseThrow(() -> new UserNotFoundException("There is no item with this id!"));

        if (!todo.belongsToUser())
            throw new UnauthorizedException("You are not authorized to do this");

        todoRepository.deleteById(id);
        return ResponseEntity.status(204).body(null);

    }

    public ResponseEntity<Page<TodoDTO>> getTodos(int page, int size, String sortBy, String status) {
        String email = ((UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getEmail();
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        List<Todo> pages = todoRepository.findTodoByUser_Email(email, pageable);

        if (status != null) {   // if filtering is enabled
            return ResponseEntity.ok(new PageImpl<>(pages.stream().filter(todo -> todo.getStatus().equals(Status.valueOf(status.trim().toUpperCase()))).map(TodoDTO::fromEntity).collect(Collectors.toList())));
        }
        // otherwise
        return ResponseEntity.ok(new PageImpl<>(pages.stream().map(TodoDTO::fromEntity).collect(Collectors.toList())));




    }

    public ResponseEntity<Page<TodoDTO>> getAllTodos(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        Page<TodoDTO> pageTodos = todoRepository.findAll(pageable).map(TodoDTO::fromEntity);
//        return ResponseEntity.ok(new PageResponse<>(page));
        return ResponseEntity.ok(pageTodos);
    }
}
