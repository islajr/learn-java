package com.demo.student1.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    public String generateToken(String username) {

        /*
        * declare a hashmap for mapping the claims
        * build the jwt token with the builder class
        * set the mapped claims
        * set the subject to be used
        * set issued date using system current milliseconds time
        * set expiry date using the difference in time
        * sign with a generated hmac sha256 key
        * compact the token so it is returned in string format
        * */

        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1200 * 1000))
                .signWith(generateKey())
                .compact();

    }

    private Key generateKey() {
        final String secret;

        /*
        * get instance of key generator and use hmac sha256 algorithm
        * generate key and store in variable of type SecretKey
        * encode to string in base64
        * decode encoded string in base64 to byte format
        * return the key in byte format using the hmacShaKey for Key method.
        * */

        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256");
            SecretKey secretKey = keyGenerator.generateKey();
            secret = Base64.getEncoder().encodeToString(secretKey.getEncoded());

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        byte[] keyByte = Base64.getDecoder().decode(secret);
        return Keys.hmacShaKeyFor(keyByte);

    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return (Claims) Jwts.parserBuilder()
                .setSigningKey(generateKey())   //
                .build()
                .parse(token)
                .getBody();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return(username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
 }
