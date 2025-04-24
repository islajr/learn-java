package org.project.todoapp.service;

import org.project.todoapp.dto.UserDTO;
import org.project.todoapp.model.User;
import org.project.todoapp.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public UserService(UserRepository userRepository, AuthenticationManager authenticationManager, JwtService jwtService) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public ResponseEntity<String> register(UserDTO userDTO) {
        User user = UserDTO.toEntity(userDTO);

        if (!user.isValid()) {
            throw new RuntimeException("Please provide a valid user");  // customize exception later
        }
        user.setPassword(new BCryptPasswordEncoder(12).encode(user.getPassword())); // encode password
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("Successfully created user");
    }

    public ResponseEntity<String> login(UserDTO userDTO) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDTO.email(), userDTO.password()));

        if (authentication.isAuthenticated()) {
            return ResponseEntity.ok(jwtService.generateToken(userDTO.email()));
        } throw new RuntimeException("Authentication failed. Please provide valid credentials.");

    }
}
