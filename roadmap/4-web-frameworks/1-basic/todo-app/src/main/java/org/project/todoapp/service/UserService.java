package org.project.todoapp.service;

import org.project.todoapp.dto.UserDTO;
import org.project.todoapp.dto.UserLoginDTO;
import org.project.todoapp.exception.exceptions.InvalidCredentialsException;
import org.project.todoapp.exception.exceptions.UserNotFoundException;
import org.project.todoapp.model.User;
import org.project.todoapp.repository.TodoRepository;
import org.project.todoapp.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final TodoRepository todoRepository;

    public UserService(UserRepository userRepository, AuthenticationManager authenticationManager, JwtService jwtService, TodoRepository todoRepository) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.todoRepository = todoRepository;
    }

    public ResponseEntity<String> register(UserDTO userDTO) {
        User user = UserDTO.toEntity(userDTO);

        if (!user.isValid()) {
            throw new InvalidCredentialsException("Please provide a valid user");
        }
        user.setPassword(new BCryptPasswordEncoder(12).encode(user.getPassword())); // encode password
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("""
                {
                    "access token": "%s",
                    "refresh token": "%s
                }
                """.formatted(jwtService.generateToken(user.getEmail()), jwtService.generateRefreshToken(user.getEmail())));
    }

    public ResponseEntity<String> login(UserLoginDTO loginDTO) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.email(), loginDTO.password()));

        if (authentication.isAuthenticated()) {
            return ResponseEntity.ok("""
                    {
                        "access token": "%s",
                        "refresh token": "%s"
                    }
                    """.formatted(jwtService.generateToken(loginDTO.email()), jwtService.generateRefreshToken(loginDTO.email())));
        } throw new BadCredentialsException("Error: Invalid credentials.");

    }

    public ResponseEntity<String> deleteUser(Long id) {
        userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Cannot delete non-existent user"));

        userRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Successfully delete user.");
    }
}
