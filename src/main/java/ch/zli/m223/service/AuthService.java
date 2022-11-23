package ch.zli.m223.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.eclipse.microprofile.jwt.Claims;

import ch.zli.m223.model.ApplicationUser;
import io.smallrye.jwt.build.Jwt;

@ApplicationScoped
public class AuthService {

  @Inject
  EntityManager entityManager;
    /**
     * Generate JWT token
     */
    public String generateToken(ApplicationUser applicationUser) {
      var email = applicationUser.getEmail();
      if (applicationUser.isAdmin()) {
        String token =
           Jwt.issuer("https://example.com/issuer") 
             .upn(email) 
             .groups("Admin") 
             .claim(Claims.given_name.name(), applicationUser.getId())
             .expiresIn(Integer.MAX_VALUE)
           .sign();
           return token;
      }
      else {
        String token =
           Jwt.issuer("https://example.com/issuer") 
             .upn(email) 
             .groups("User") 
             .claim(Claims.given_name.name(), applicationUser.getId())
             .expiresIn(Integer.MAX_VALUE)
           .sign();
           return token;
      }
    }

    @Transactional
    public String register(ApplicationUser applicationUser) {
      entityManager.persist(applicationUser);
      return generateToken(applicationUser);
    }
}