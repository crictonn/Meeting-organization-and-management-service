package com.example.meetingsmanagmentandorganization.jwt;

import com.example.meetingsmanagmentandorganization.model.UserDetailsImplementation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.*;

import java.util.Date;

@Component
public class JwtCore {

    @Value("${meetings.app.secret}")
    private String secret;

    @Value("${meetings.app.lifetime}")
    private int lifetime;

    public String generateToken(Authentication authentication){
        UserDetailsImplementation userDetails = (UserDetailsImplementation)authentication.getPrincipal();
        return Jwts.builder()
                .header()
                .add("Authorization", "Bearer ")
                .and()
                .claim("username", (userDetails.getUsername()))
                .claim("role", (userDetails.getRole()))
                .issuedAt(new Date())
                .expiration(new Date((new Date()).getTime() + lifetime))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public String getNameFromJwt(String token){
        return Jwts.parser().setSigningKey(secret).build().parseSignedClaims(token).getBody().getSubject();
    }
}
