package com.example.demo.service;

import com.example.demo.constant.ERole;
import com.example.demo.domain.JWTData;
import io.jsonwebtoken.Claims;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService{
    private static final String KEY = "a-very-secure-server-key-of-phoenix";

    public String generateToken(String userId, String email, ERole role) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", userId);
        claims.put("email", email);
        claims.put("role", role);
        String token = Jwts.builder()
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS256, KEY.getBytes())
                .compact();
        return token;
    }

    public String parseTokenToRole(String token) {
        if (token == null) {
            return null;
        }
        Claims claims = Jwts.parserBuilder().setSigningKey(KEY.getBytes()).build()
                .parseClaimsJws(token).getBody();
        return claims.get("role").toString();
    }

    public String parseTokenToUserId(String token){
        if (token == null) {
            return null;
        }
        Claims claims = Jwts.parserBuilder().setSigningKey(KEY.getBytes()).build()
                .parseClaimsJws(token).getBody();
        return claims.get("userId").toString();
    }

//    userid = parseTokenToUserId(token)
//    ///...
//    email = parseTokenToEmail(token)
//        ///
//    role = parseToRole(token)
//        jwtData = parse(token)
//    userid = jwtData.user

    public String parseTokenToEmail(String token){
        if (token == null) {
            return null;
        }
        Claims claims = Jwts.parserBuilder().setSigningKey(KEY.getBytes()).build()
                .parseClaimsJws(token).getBody();
        return claims.get("email").toString();
    }

    public JWTData getDataFromToken(String token){
        if (token == null) {
            return null;
        }
        Claims claims = Jwts.parserBuilder().setSigningKey(KEY.getBytes()).build()
                .parseClaimsJws(token).getBody();
        String email = claims.get("email").toString();
        String userID = claims.get("userId").toString();
        String role = claims.get("role").toString();
        return new JWTData(userID, email, role);
    }

}
