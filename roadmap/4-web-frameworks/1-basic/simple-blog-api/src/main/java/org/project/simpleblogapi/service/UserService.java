package org.project.simpleblogapi.service;

import org.project.simpleblogapi.model.User;
import org.project.simpleblogapi.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(User user) {
        userRepository.save(user);
    }
}
