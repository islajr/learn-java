package com.example.student.student.service;

import com.example.student.student.model.user;
import com.example.student.student.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class userService {

    @Autowired
    private UserRepository userRepository;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public user registerUser(user _user) {
        _user.setPassword(encoder.encode(_user.getPassword()));
        return userRepository.save(_user);
    }
}
