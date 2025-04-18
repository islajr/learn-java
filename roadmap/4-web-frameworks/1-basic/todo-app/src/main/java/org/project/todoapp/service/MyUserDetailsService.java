package org.project.todoapp.service;

import lombok.AllArgsConstructor;
import org.project.todoapp.model.User;
import org.project.todoapp.model.UserPrincipal;
import org.project.todoapp.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        if (email == null || email.isEmpty()) {
            throw new UsernameNotFoundException("Please provide an email address");   // customize exception later.
        }

        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new RuntimeException("User does not exist. Please provide a VALID email address"); // customize exception later.
        }

        return new UserPrincipal(user);
    }
}
