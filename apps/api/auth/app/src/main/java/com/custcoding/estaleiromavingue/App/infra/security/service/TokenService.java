package com.custcoding.estaleiromavingue.App.infra.security.service;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.custcoding.estaleiromavingue.App.models.User;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.*;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(User user){
        try {

            if (secret == null || secret.isEmpty()){
                throw new RuntimeException("Secret key is not configured");
            }

            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("mavingue")
                    .withSubject(user.getUsername())
                    .withExpiresAt(generateExpirationDate())
                    .sign(algorithm);
            return token;
        }catch (JWTCreationException exception){
            throw  new RuntimeException("Error while generating a token", exception);
        }


    }

    public String validateToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("mavingue")
                    .build()
                    .verify(token)
                    .getSubject();
        }catch (JWTVerificationException exception){
            return "";

        }
    }

    private Instant generateExpirationDate(){
        return LocalDateTime.now(ZoneId.of("Africa/Maputo"))
                .plusHours(8).
                toInstant(ZoneOffset.of("+02:00"));
    }

}
