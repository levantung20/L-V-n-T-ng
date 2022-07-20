package com.example.demo.service;

import com.example.demo.constant.ERole;
import io.jsonwebtoken.Claims;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService{
    private static final String KEY = "a-very-secure-server-key-of-phoenix";

    public String generateToken(String email, ERole role) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("email", email);
        claims.put("role", role);
        String token = Jwts.builder()
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS256, KEY.getBytes())
                .compact();
        return token;
    }

    public String convertToken(String token) {
        Claims claims = Jwts.parserBuilder().setSigningKey(KEY.getBytes()).build()
                .parseClaimsJws(token).getBody();
        System.out.println(claims.get("email").toString());
        System.out.println(claims.get("role").toString());
        return claims.get("role").toString();

    }


}
