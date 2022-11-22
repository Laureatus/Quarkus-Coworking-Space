package ch.zli.m223.controller;

import javax.inject.Inject;
import javax.ws.rs.Path;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.service.AuthService;

@Path("/auth")
@Tag(name = "auth", description = "Handling of authentication")
public class AuthController {

    
    
    @Inject
    AuthService authService;
}
