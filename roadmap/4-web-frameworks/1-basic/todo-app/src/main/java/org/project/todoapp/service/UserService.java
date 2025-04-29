package org.project.todoapp.service;

import org.project.todoapp.dto.UserDTO;
import org.project.todoapp.dto.UserLoginDTO;
import org.project.todoapp.model.Todo;
import org.project.todoapp.model.User;
import org.project.todoapp.repository.TodoRepository;
import org.project.todoapp.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

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
            throw new RuntimeException("Please provide a valid user");  // customize exception later
        }
        user.setPassword(new BCryptPasswordEncoder(12).encode(user.getPassword())); // encode password
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(jwtService.generateToken(user.getEmail()));
    }

    public ResponseEntity<String> login(UserLoginDTO loginDTO) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.email(), loginDTO.password()));

        if (authentication.isAuthenticated()) {
            return ResponseEntity.ok(jwtService.generateToken(loginDTO.email()));
        } throw new RuntimeException("Authentication failed. Please provide valid credentials.");

    }

    public ResponseEntity<String> deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Cannot delete non-existent user"));    // customize exception later.

        userRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Successfully delete user.");
    }


    public ResponseEntity<List<Todo>> getAllTodos() {
        return ResponseEntity.ok(todoRepository.findAll());
    }

    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }
}
