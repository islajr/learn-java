package com.example.security_demo.service;

import org.springframework.stereotype.Service;

import com.example.security_demo.model.User;
import com.example.security_demo.repository.UserRepository;

@Service
public class UsersService {
    private final UserRepository userRepository;

    public UsersService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public void createUser(User user) {
        UserRepository.save();
    }
}
