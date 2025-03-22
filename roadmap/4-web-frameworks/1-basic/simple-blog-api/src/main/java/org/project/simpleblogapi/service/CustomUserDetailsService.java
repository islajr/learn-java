package org.project.simpleblogapi.service;

import org.project.simpleblogapi.exception.UserDoesNotExistException;
import org.project.simpleblogapi.model.User;
import org.project.simpleblogapi.repository.UserRepository;
import org.project.simpleblogapi.model.UserPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);

        if (username == null || username.isEmpty()) {
            System.out.println("Please provide a valid username");
            throw new UsernameNotFoundException("Please provide a valid Username");
        }
        if (user == null) {
            System.out.println("User does not exist!");
            throw new UserDoesNotExistException("User does not exist!");
        }

        return new UserPrincipal(user);
    }
}
