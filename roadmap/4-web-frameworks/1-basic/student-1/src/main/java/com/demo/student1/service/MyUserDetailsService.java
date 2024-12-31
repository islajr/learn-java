package com.demo.student1.service;

import com.demo.student1.model.User;
import com.demo.student1.model.UserPrincipal;
import com.demo.student1.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);

        if (user == null){
            System.out.println("User not found! ");
            throw new UsernameNotFoundException("User not found!");
        }

        return new UserPrincipal(user);
    }
}
