package com.example.student.student.service;

import com.example.student.student.model.user;
import com.example.student.student.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class userService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private jwtService _jwtService;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public String registerUser(user _user) {
        _user.setPassword(encoder.encode(_user.getPassword()));
        userRepository.save(_user);
        return "Successfully registered new user \"" + _user.getUsername() + "\".";
    }

    public String verify (user _user) {
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(_user.getUsername(), _user.getPassword()));

        if (authentication.isAuthenticated()) {
            return _jwtService.generateToken(_user.getUsername());

        }

        // else
        System.out.println("Authentication Failed");
        return "Authentication Failed";
    }
}
