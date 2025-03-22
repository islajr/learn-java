package org.project.simpleblogapi.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class JwtService {

    public JwtService() {
    }

    private static final SecretKey secretKey = Jwts.SIG.HS256.key().build();

    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();

        return Jwts.builder()
                .subject(username)
                .claims()
                .add(claims)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000))
                .and()
                .signWith(secretKey).compact();
    }

    public String extractUsername(String token) {
        return (extractClaims(token).getSubject());
    }


    private Claims extractClaims(String token) {
        try {
           return  Jwts.parser()
                    .verifyWith(secretKey)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
        } catch (JwtException e) {
            throw new JwtException("This is not a valid jwt token");
        }
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        return (Objects.equals(extractUsername(token), userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractClaims(token).getExpiration().before(new Date(System.currentTimeMillis()));

    }
}
