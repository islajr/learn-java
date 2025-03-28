package org.project.expensetrackerapi.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JwtService {

    public String generateToken(String username) {

    }

    public String extractUsername(String token) {
    }

    public boolean validateToken(String token, UserDetails userDetails) {
    }
}
