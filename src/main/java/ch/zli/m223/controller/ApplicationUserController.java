package ch.zli.m223.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import com.oracle.svm.core.annotate.Inject;

import ch.zli.m223.model.ApplicationUser;
import ch.zli.m223.service.ApplicationUserService;

@Path("/user")
@Tag(name = "Users", description = "Handling of users")
public class ApplicationUserController {
    @Inject
    ApplicationUserService applicationUserService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "Index all users.", 
        description = "Returns a list of all users."
    )
    public List<ApplicationUser> index() {
        return applicationUserService.findAll();
    }
}
