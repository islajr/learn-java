package com.demo.student1.service;

import com.demo.student1.model.User;
import com.demo.student1.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String register(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        return "Successfully registered new user \"" + user.getUsername() + "\".";
    }
}
