package ch.zli.m223.service;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.jwt.Claims;

import ch.zli.m223.model.ApplicationUser;
import io.smallrye.jwt.build.Jwt;

@ApplicationScoped
public class AuthService {
    /**
     * Generate JWT token
     */
    public String generateToken(ApplicationUser applicationUser) {
      if (applicationUser.isAdmin()) {
        String token =
           Jwt.issuer("https://example.com/issuer") 
             .upn("jdoe@quarkus.io") 
             .groups("Admin") 
             .claim(Claims.birthdate.name(), "2001-07-13") 
             .expiresIn(86400)
           .sign();
           return token;
      }
      else {
        String token =
           Jwt.issuer("https://example.com/issuer") 
             .upn("jdoe@quarkus.io") 
             .groups("User") 
             .claim(Claims.birthdate.name(), "2001-07-13") 
             .expiresIn(86400)
           .sign();
           return token;
      }
    }
}