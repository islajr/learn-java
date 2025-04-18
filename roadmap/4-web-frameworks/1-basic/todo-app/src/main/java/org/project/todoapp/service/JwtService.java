package org.project.todoapp.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.project.todoapp.model.UserPrincipal;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {

    private final SecretKey secretKey = Jwts.SIG.HS256.key().build();

    public String generateToken(String email) {
        Map<String, Object> claims = new HashMap<>();

        return Jwts.builder()
                .subject(email)
                .claims(claims)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + (60 * 60 * 1000)))
                .signWith(secretKey)
                .compact();

    }

    private Claims extractClaims(String token) {
        try {
            return Jwts.parser()
                    .verifyWith(secretKey)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
        } catch (JwtException e) {
            throw new RuntimeException("This is an invalid token");
        }
    }

    public String extractEmail(String token) {
        return extractClaims(token).getSubject();
    }

    public boolean validateToken(String token, UserPrincipal userPrincipal) {
        return extractEmail(token).equals(userPrincipal.getEmail()) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return new Date(System.currentTimeMillis()).after(extractClaims(token).getExpiration());
    }
}
