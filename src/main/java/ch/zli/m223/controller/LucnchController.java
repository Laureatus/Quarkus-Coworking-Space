package ch.zli.m223.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.model.Lunch;
import ch.zli.m223.service.LunchService;

@Path("/lunch")
@Tag(name = "Lunch", description = "Handling of lunch Breaks")
public class LucnchController {
    
    @Inject
    LunchService lunchService;

    @GET
    @RolesAllowed({ "Admin" , "User"})
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "Index all lunch Breaks.", 
        description = "Returns a list of all lunch breaks."
    )
    public List<Lunch> index() {
        return lunchService.findAll();
    }

    @POST
    @RolesAllowed({ "Admin", "User" })
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Lunch create(Lunch lunch) {
        return lunchService.createLunch(lunch);
    }

    @Path("/{id}")
    @DELETE
    @RolesAllowed({ "Admin", "User" })
    @Operation(
        summary = "Deletes a lunch break.",
        description = "Deletes a lunch break by its id."
    )
    public void delete(@PathParam("id") Long id) {
        lunchService.deleteLunch(id);
    }

    @Path("/{id}")
    @PUT
    @RolesAllowed({ "Admin", "User" })
    @Operation(
        summary = "Updates a lunch break.",
        description = "Updates a lunch break by its id."
    )
    public Lunch update(@PathParam("id") Long id, Lunch lunch) {
        return lunchService.updateLunch(id, lunch);
    }
}
