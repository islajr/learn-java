package org.project.todoapp.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.project.todoapp.dto.UserDTO;
import org.project.todoapp.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private JwtService jwtService;

    @Mock
    private MyUserDetailsService myUserDetailsService;

    private AutoCloseable autoCloseable;

    private UserService userService;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        userService = new UserService(userRepository, authenticationManager, jwtService, myUserDetailsService);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void register() {
        UserDTO sample = new UserDTO("Name", "name@email.com", "name@123", "USER");
        userService.register(sample);
        verify(userRepository).save(UserDTO.toEntity(sample));
    }

    @Disabled
    @Test
    void login() {
    }
}