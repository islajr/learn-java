package org.project.todoapp.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.project.todoapp.dto.UserDTO;
import org.project.todoapp.dto.UserLoginDTO;
import org.project.todoapp.model.Role;
import org.project.todoapp.model.User;
import org.project.todoapp.model.UserPrincipal;
import org.project.todoapp.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private JwtService jwtService;

    @Mock
    private MyUserDetailsService myUserDetailsService;

    @Mock
    private Authentication authentication;

    @Mock
    private UserPrincipal userPrincipal;

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService(userRepository, authenticationManager, jwtService, myUserDetailsService);
    }

    @Test
    void registerTest() {
        UserDTO sample = new UserDTO("Name", "name@email.com", "name@123", "USER");
        User sampleUser = UserDTO.toEntity(sample);
        String token = "token";
        String refresh = "refresh";
        String responseModel = """
                {
                    "access token": token,
                    "refresh token": refresh
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
    void loginTest() {
        UserLoginDTO loginDTO = new UserLoginDTO("login@email.com", "password");

        String token = "token";
        String refresh = "refresh";
        String responseModel = """
                {
                    "access token": token,
                    "refresh token": refresh
                }
                """;

        when (authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.email(), loginDTO.password()))).thenReturn(authentication);
        when (authentication.isAuthenticated()).thenReturn(true);
        when (jwtService.generateToken(loginDTO.email())).thenReturn(token);
        when (jwtService.generateRefreshToken(loginDTO.email())).thenReturn(refresh);

        ResponseEntity<String> response = userService.login(loginDTO);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(responseModel, response.getBody());

    }

    @Test
    void deleteUser() {

        User sampleUser = new User(
                1L, "user", "user@email.com", "user@123", Role.USER, "USER"
        );
        String expectedResponseBody = "Successfully deleted user.";
        HttpStatus expectedStatus = HttpStatus.NO_CONTENT;
        userRepository.save(sampleUser);

        when (userRepository.findById(sampleUser.getId())).thenReturn(Optional.of(sampleUser));
        ResponseEntity<String> response = userService.deleteUser(sampleUser.getId());

        verify(userRepository).findById(sampleUser.getId());

        assertNotNull(response);
        assertEquals(expectedStatus, response.getStatusCode());
        assertEquals(expectedResponseBody, response.getBody());

    }

    @Test
    void refreshTest() {
        String refreshToken = "token";
        String access = "access";
        String refresh = "refresh";
        String email = "user@email.com";
        String expectedResponse = """
                    {
                         "access token": access,
                         "refresh token": refresh
                    }
                    """;

        when(jwtService.extractEmail(refreshToken)).thenReturn(email);
        when(myUserDetailsService.loadUserByUsername(email)).thenReturn(userPrincipal);
        when(jwtService.validateToken(refreshToken, userPrincipal)).thenReturn(true);
        when(jwtService.generateToken(email)).thenReturn(access);
        when(jwtService.generateRefreshToken(email)).thenReturn(refresh);

        ResponseEntity<String> response = userService.refresh(refreshToken);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResponse, response.getBody());


    }
}