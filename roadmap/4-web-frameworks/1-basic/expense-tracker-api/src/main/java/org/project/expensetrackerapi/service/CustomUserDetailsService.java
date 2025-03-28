package org.project.expensetrackerapi.service;

import lombok.AllArgsConstructor;
import org.project.expensetrackerapi.model.User;
import org.project.expensetrackerapi.model.UserPrincipal;
import org.project.expensetrackerapi.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("No such user!"));

        if (user != null && user.getUsername().equals(username)) {
            return new UserPrincipal(user);
        }

        return null;
    }
}
