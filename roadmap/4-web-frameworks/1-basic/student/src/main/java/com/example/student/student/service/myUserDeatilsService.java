package com.example.student.student.service;

import com.example.student.student.repository.UserRepository;
import com.example.student.student.model.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class myUserDeatilsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        user _user = userRepository.findByUsername(username);

        if (_user == null) {
            System.out.println("User not found!");
            throw new UsernameNotFoundException("User not found!");
        }


        return null;
    }
}
