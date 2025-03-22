package org.project.simpleblogapi.service;

import io.jsonwebtoken.lang.Objects;
import org.project.simpleblogapi.exception.AuthenticationFailedException;
import org.project.simpleblogapi.exception.NullUserException;
import org.project.simpleblogapi.model.User;
import org.project.simpleblogapi.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    private final JwtService jwtService;

    public UserService(UserRepository userRepository, AuthenticationManager authenticationManager, JwtService jwtService) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public void register(User user) {

        if (!Objects.isEmpty(user) || user != null) {
            user.setPassword(encoder.encode(user.getPassword()));
            userRepository.save(user);
            System.out.println("Successfully registered new user " + user.getUsername());
        } else {
            throw new NullUserException("There is no user provided!");
        }

    }

    public String login(User user) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(user.getUsername());
        } else {
            throw new AuthenticationFailedException("Wrong username and/or password");
        }

    }
}
