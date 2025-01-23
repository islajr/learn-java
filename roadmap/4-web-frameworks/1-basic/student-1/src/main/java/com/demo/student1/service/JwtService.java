package com.demo.student1.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

//    final Key secret;
    final Key secretKey = Jwts.SIG.HS256.key().build();

    public JwtService() {

        /*
         * get instance of key generator and use hmac sha256 algorithm
         * generate key and store in variable of type SecretKey
         * encode to string in base64
         * decode encoded string in base64 to byte format
         * return the key in byte format using the hmacShaKey for Key method.
         * */

        /*try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256");
            SecretKey secretKey = keyGenerator.generateKey();
            secret = Base64.getEncoder().encodeToString(secretKey.getEncoded());

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }*/

    }

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
                .claims(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1200 * 1000))
                .signWith(secretKey)
                .compact();

    }

  /*  private Key generateKey() {
        *//*
        * proceeded to set this method to simply decode the base64 string 'secret'.
        * *//*

        byte[] keyByte = Base64.getDecoder().decode(secret);
        return Keys.hmacShaKeyFor(keyByte);

    }*/

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith((SecretKey) secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();

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
