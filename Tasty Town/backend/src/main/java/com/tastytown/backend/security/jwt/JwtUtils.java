package com.tastytown.backend.security.jwt;

import java.util.Base64;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtils {
    private static final String JWT_SECRET = 
                            "35dd3528d20f9e3cf604ca54c1161b511f1e4338dcd6f78f6eeeee9504befa22";

    private SecretKey getKey() {
        byte[] keyBytes = Base64.getDecoder().decode(JWT_SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(String userId, String role) {
        return Jwts.builder()
                .subject(userId)
                .claim("role", role)
                .signWith(getKey())
                .compact();
    }

    public String getUserId(String token) { // verifyToken, verify, claimUsername
        return Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    public String getUserRole(String token) { // verifyToken, verify, claimUsername
        return Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .get("role")
                .toString();
    }
}
