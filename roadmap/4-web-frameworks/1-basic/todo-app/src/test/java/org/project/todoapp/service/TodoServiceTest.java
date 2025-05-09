package org.project.todoapp.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.project.todoapp.dto.TodoDTO;
import org.project.todoapp.repository.TodoRepository;
import org.project.todoapp.repository.UserRepository;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class TodoServiceTest {

    @Mock
    TodoRepository todoRepository;

    @Mock
    UserRepository userRepository;

    private TodoService todoService;

    @BeforeEach
    void setUp() {
        todoService = new TodoService(todoRepository, userRepository);
    }


    @Disabled
    @Test
    void createTodoTest() {

       /* TodoDTO todoDTO = new TodoDTO();

        ResponseEntity<TodoDTO> response = todoService.createTodo(todoDTO);*/
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