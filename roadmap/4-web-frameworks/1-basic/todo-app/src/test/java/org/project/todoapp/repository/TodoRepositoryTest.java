package org.project.todoapp.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.project.todoapp.model.Role;
import org.project.todoapp.model.Status;
import org.project.todoapp.model.Todo;
import org.project.todoapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class TodoRepositoryTest {

    @Autowired
    private TodoRepository todoRepository;

    @Mock
    private Pageable pageable;

    @Test
    void findTodoByUser_Email() {
        User sampleUser = new User(
                1L, "user", "user@email.com", "user@123", Role.USER, "USER"
        );
        Todo todo = new Todo(1L, "Do something", "Actually do something", Status.INCOMPLETE, sampleUser);
        List<Todo> todos = new ArrayList<>();
        todos.add(todo);

        todoRepository.save(todo);
        List<Todo> response = todoRepository.findTodoByUser_Email(sampleUser.getEmail(), pageable);

        assertEquals(todos, response);
    }

    @Test
    void findTodoByUser_EmailAndStatus() {
    }

    @Test
    void findTodoByStatus() {
    }
}