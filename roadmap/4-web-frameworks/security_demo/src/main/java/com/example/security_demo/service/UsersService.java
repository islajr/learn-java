package com.example.security_demo.service;

import com.example.security_demo.model.User;
import com.example.security_demo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    private final UserRepository userRepository;

    public UsersService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) {
        userRepository.save(user);
    }
}
