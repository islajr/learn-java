package org.project.expensetrackerapi.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import lombok.AllArgsConstructor;
import org.project.expensetrackerapi.exception.exceptions.InvalidTokenException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
@AllArgsConstructor
public class JwtService {


    private final SecretKey signingKey = Jwts.SIG.HS256.key().build();

    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder()
                .subject(username)
                .claims()
                .add(claims)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + (30 * 60 * 1000)))
                .and()
                .signWith(signingKey)
                .compact();

    }

   /*  private SecretKey generateKey() {
        return Jwts.SIG.HS256.key().build();
    } */

    private Claims extractClaims(String token) {
        try {
           return Jwts.parser()
                    .verifyWith(signingKey)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
        } catch (JwtException e) {
            System.out.println(e.getMessage());
            throw new InvalidTokenException("The provided token has probably expired.");
        }

    }

    public String extractUsername(String token) {
        Claims claims = extractClaims(token);
        return claims.getSubject();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        return (Objects.equals(extractUsername(token), userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractClaims(token).getExpiration().before(new Date(System.currentTimeMillis()));
    }
}
