package org.project.expensetrackerapi.service;

import lombok.AllArgsConstructor;
import org.project.expensetrackerapi.model.User;
import org.project.expensetrackerapi.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public String login(User user) {

        if (user != null) {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

            if (authentication.isAuthenticated()) {
                return jwtService.generateToken(user.getUsername());
            }

            throw new RuntimeException("Authentication Failed!");
        }

        throw new RuntimeException("User is null.");
    }

    public ResponseEntity<String> register(User user) {

        if (user != null) {
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            userRepository.save(user);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("Successfully registered new user " + user.getUsername() + ".");
        }
        return ResponseEntity
                .badRequest()
                .body("User is null!");
    }
}
