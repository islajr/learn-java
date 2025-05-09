package org.project.todoapp.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.project.todoapp.dto.TodoDTO;
import org.project.todoapp.model.Todo;
import org.project.todoapp.model.User;
import org.project.todoapp.model.UserPrincipal;
import org.project.todoapp.repository.TodoRepository;
import org.project.todoapp.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TodoServiceTest {

    @Mock
    private TodoRepository todoRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private SecurityContextHolder securityContextHolder;

    private TodoService todoService;

    @BeforeEach
    void setUp() {
        todoService = new TodoService(todoRepository, userRepository);
    }

    @Test
    void createTodoTest() {
        TodoDTO todoDTO = new TodoDTO("title", "description");
        User sampleUser = new User("user", "user@email.com");

        when(((UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getEmail()).thenReturn(sampleUser.getEmail());
        when(userRepository.findByEmail(sampleUser.getEmail())).thenReturn(sampleUser);

        ResponseEntity<TodoDTO> response = todoService.createTodo(todoDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Disabled
    @Test
    void updateTodoTest() {
    }

    @Disabled
    @Test
    void deleteTodoTest() {
    }

    @Disabled
    @Test
    void getTodosTest() {
    }

    @Disabled
    @Test
    void getAllTodosTest() {
    }
}