package com.example.student.student.service;

import com.example.student.student.model.user;
import com.example.student.student.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userService {

    @Autowired
    private UserRepository userRepository;

    public user registerUser(user _user) {
        return userRepository.save(_user);
    }
}
