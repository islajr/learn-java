package com.example.security_demo.service;

import com.example.security_demo.controller.UserPrincipal;
import com.example.security_demo.model.User;
import com.example.security_demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UsersDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);

        if (user == null) {
            System.out.println("User not found! ");
            throw new UsernameNotFoundException("User not found! ");
        }
        return new UserPrincipal(user);
    }
}
