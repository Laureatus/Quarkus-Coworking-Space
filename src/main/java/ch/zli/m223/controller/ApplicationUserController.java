package ch.zli.m223.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;



import ch.zli.m223.model.ApplicationUser;
import ch.zli.m223.service.ApplicationUserService;
import ch.zli.m223.service.AuthService;

@Path("/user")
@Tag(name = "Users", description = "Handling of users")
public class ApplicationUserController {
    @Inject
    ApplicationUserService applicationUserService;

    @Inject
    AuthService authService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "Index all users.", 
        description = "Returns a list of all users."
    )
    public List<ApplicationUser> index() {
        return applicationUserService.findAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ApplicationUser createUser(ApplicationUser applicationUser) {
        return applicationUserService.createUser(applicationUser);
    }


    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String login(ApplicationUser user) {
       ApplicationUser foundUser = applicationUserService.findAll().stream().filter(dbuser->dbuser.getEmail().equals(user.getEmail()) && dbuser.getPassword().equals(user.getPassword())).findAny().orElse(null);
       if (foundUser != null) {
        return authService.generateToken();
       }
        return "";
    }
}
