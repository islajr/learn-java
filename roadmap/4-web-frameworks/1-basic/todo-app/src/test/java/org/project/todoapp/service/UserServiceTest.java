package org.project.todoapp.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.project.todoapp.dto.UserDTO;
import org.project.todoapp.model.User;
import org.project.todoapp.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private JwtService jwtService;

    @Mock
    private PasswordEncoder passwordEncoder;

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

    @Disabled
    @Test
    void register() {
        UserDTO sample = new UserDTO("Name", "name@email.com", "name@123", "USER");
        User sampleUser = UserDTO.toEntity(sample);
        String token = "token";
        String refresh = "refresh";
        String responseModel = """
                {
                    "access token": "token",
                    "refresh token": "refresh"
                }
                """;

        when (jwtService.generateToken(sampleUser.getEmail())).thenReturn(token);
        when (jwtService.generateRefreshToken(sampleUser.getEmail())).thenReturn(refresh);

        ResponseEntity<String> response = userService.register(sample);

        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(responseModel, response.getBody());
    }

    @Test
    void login() {

    }
}