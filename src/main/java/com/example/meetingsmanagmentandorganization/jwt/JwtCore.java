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
        return Jwts.builder().subject((userDetails.getUsername()))
                .issuedAt(new Date())
                .expiration(new Date((new Date()).getTime() + lifetime))
                .signWith(Jwts.SIG.HS256.key().build())
                .compact();
    }

    public String getNameFromJwt(String token){
        return Jwts.parser().build().parseSignedClaims(token).getBody().getSubject();
    }
}
