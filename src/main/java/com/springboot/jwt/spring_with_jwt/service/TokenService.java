package com.springboot.jwt.spring_with_jwt.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Date;

@Service
public class TokenService {

    public static final String token_secret = "asdfasdf1234";

    public String createToken(ObjectId userId){
        try{
            // Random generating string using token secret
            // we are using HMAC256 algo to generate the Token
            Algorithm jwtAlgo = Algorithm.HMAC256(token_secret);


            // We are using claims of UserId and Created Date using Date Object
            String token = JWT
                           .create()
                           .withClaim("userId", userId.toString())
                           .withClaim("createdAt", new Date())
                           .sign(jwtAlgo);

            return token;
        }
        catch(UnsupportedEncodingException ex1){
            ex1.printStackTrace();
        }
        catch(JWTCreationException ex2){
            ex2.printStackTrace();
        }
        catch(Exception ex3){
            ex3.printStackTrace();
        }
        return null;
    }

    public String getUserIdFromToken(String token){
        try{
            //Randomly generating string using token_secret. We are using HMA256 Algorithm to generate the token
            Algorithm algorithm = Algorithm.HMAC256(token_secret);
            JWTVerifier jwtVerifier=JWT.require(algorithm).build();
            DecodedJWT decodedJWT=jwtVerifier.verify(token);
            return decodedJWT.getClaim("userId").asString();
        }
        catch(UnsupportedEncodingException exception){
            exception.printStackTrace();
        }
        catch (JWTCreationException exception){
            exception.printStackTrace();
        }
        return null;
    }

}
