package org.project.todoapp.repository;

import org.junit.jupiter.api.Test;
import org.project.todoapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository testRepo;

    @Test
    void findByEmail() {
        User user = new User("testUser", "testuser@gmail.com");
        testRepo.save(user);
        assertEquals(testRepo.findByEmail(user.getEmail()), user);
    }


}