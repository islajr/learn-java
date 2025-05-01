package org.project.todoapp.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.project.todoapp.model.UserPrincipal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {

    final String secret;

    @Value("${jwt.security.expiration}")
    long expiration;

    @Value("${jwt.security.refresh.expiration}")
    long refreshExpiration;

   /* public JwtService(@Value("${jwt.security.secret}") String secret,
                      @Value("${jwt.security.expiration}") long expiration) {
        this.secretKey = Keys.hmacShaKeyFor(secret.getBytes());
        this.expiration = expiration;
    }*/

    public JwtService() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256");
            SecretKey secretKey = keyGenerator.generateKey();
            secret = Base64.getEncoder().encodeToString(secretKey.getEncoded());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private SecretKey generateKey() {
        byte[] keyByte = Decoders.BASE64.decode(secret);
        System.out.println(secret);
        return Keys.hmacShaKeyFor(keyByte);
    }

    public String generateToken(String email) {
        Map<String, Object> claims = new HashMap<>();

        try {

            return Jwts.builder()
                    .subject(email)
                    .claims(claims)
                    .issuedAt(new Date(System.currentTimeMillis()))
                    .expiration(new Date(System.currentTimeMillis() + expiration))
                    .signWith(generateKey())
                    .compact();
        } catch (JwtException e) {
            throw new JwtException("Failed to generate token");
        }
    }

    public String generateRefreshToken(String email) {
        Map<String, Object> claims = new HashMap<>();

        try {

            return Jwts.builder()
                    .subject(email)
                    .claims(claims)
                    .issuedAt(new Date(System.currentTimeMillis()))
                    .expiration(new Date(System.currentTimeMillis() + refreshExpiration))
                    .signWith(generateKey())
                    .compact();
        } catch (JwtException e) {
            throw new JwtException("Failed to generate token");
        }
    }

    private Claims extractClaims(String token) {
        try {
            return Jwts.parser()
                    .verifyWith(generateKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
        } catch (JwtException e) {
            throw new JwtException("This is an invalid token");
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
