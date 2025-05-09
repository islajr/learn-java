/*
package org.project.todoapp.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.project.todoapp.model.Role;
import org.project.todoapp.model.Status;
import org.project.todoapp.model.Todo;
import org.project.todoapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@ExtendWith(MockitoExtension.class)
class TodoRepositoryTest {

    @Autowired
    private TodoRepository todoRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private Pageable pageable;

    @Test
    void findTodoByUser_Email() {
        User sampleUser = new User(
                "user", "user@email.com"
        );
        Todo todo = new Todo("Do something", "Actually do something", Status.INCOMPLETE, sampleUser);
        List<Todo> todos = new ArrayList<>();
        todos.add(todo);

        userRepository.save(sampleUser);
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
}*/
