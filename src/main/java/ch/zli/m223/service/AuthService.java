package ch.zli.m223.service;

import java.util.Arrays;
import java.util.HashSet;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.jwt.Claims;

import io.smallrye.jwt.build.Jwt;

@ApplicationScoped
public class AuthService {
    /**
     * Generate JWT token
     */
    public String generateToken() {
        String token =
           Jwt.issuer("https://example.com/issuer") 
             .upn("jdoe@quarkus.io") 
             .groups(new HashSet<>(Arrays.asList("User", "Admin"))) 
             .claim(Claims.birthdate.name(), "2001-07-13") 
           .sign();
        return token;
    }
}