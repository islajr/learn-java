package org.project.simpleblogapi.service;

import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {

    public JwtService() {
    }

    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        Key secretKey = Jwts.SIG.HS256.key().build();

        return Jwts.builder()
                .subject(username)
                .claims()
                .add(claims)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() * 60 * 60 * 1000))
                .and()
                .signWith(secretKey).compact();
    }
}
