package com.example.barberbookingsystembackend.Service;

import com.example.barberbookingsystembackend.Entity.Costumer;
import com.example.barberbookingsystembackend.Entity.Employee;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;


@Service
public class JwtService {
    private Key secretKey;
    public JwtService(@Value("${app.api-key}") String secretKeyEncoded) {
        this.secretKey = Keys.hmacShaKeyFor(Base64.getDecoder().decode(secretKeyEncoded));
    }


    public String generateToken(Costumer costumer) {
        return Jwts.builder()
                .setSubject(costumer.getEmail())
                .claim("name",costumer.getFirstName())
                .claim("id",costumer.getId())
                .setIssuedAt(new Date())
                .setExpiration(Date.from(Instant.now().plus(1, ChronoUnit.DAYS)))
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }
    public String generateToken(Employee employee) {
        return Jwts.builder()
                .setSubject(employee.getEmail())
                .claim("name",employee.getFirstName())
                .claim("id",employee.getId())
                .setIssuedAt(new Date())
                .setExpiration(Date.from(Instant.now().plus(1, ChronoUnit.DAYS)))
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }
    public String extractEmail (String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    }
