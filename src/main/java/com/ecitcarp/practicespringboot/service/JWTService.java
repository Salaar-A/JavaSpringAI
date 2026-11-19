package com.ecitcarp.practicespringboot.service;

import com.ecitcarp.practicespringboot.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JWTService {

    Logger log = LoggerFactory.getLogger(JWTService.class);

    @Value("${secertkey.value}")
    private String secertKey;

    private SecretKey getSecretKey(){
        return Keys.hmacShaKeyFor(secertKey.getBytes(StandardCharsets.UTF_8));
    }

    public String generateToken(User user){
        log.info("Entering inside the generate JWT Token {}",user.getUserName());
        return Jwts.builder().subject(user.getUserName())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() +1000*60))
                .signWith(getSecretKey())
                .compact();
    }

    public String getUserNameFromToken(String token){
        log.info("Inside the get name method with token method{}",token);
        Claims claims = Jwts
                .parser()
                .verifyWith(getSecretKey()).build().parseSignedClaims(token).getPayload();
        return String.valueOf(claims.getSubject());
    }


}
