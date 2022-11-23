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



import ch.zli.m223.model.Coffee;
import ch.zli.m223.service.CoffeeService;

@Path("/coffee")
@Tag(name = "Coffee", description = "Handling of Coffee Breaks")
public class CoffeeController {
    
    @Inject
    CoffeeService coffeeService;

    @GET
    @RolesAllowed({ "Admin" , "User"})
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "Index all Coffee Breaks.", 
        description = "Returns a list of all Coffee breaks."
    )
    public List<Coffee> index() {
        return coffeeService.findAll();
    }

    @POST
    @RolesAllowed({ "Admin", "User" })
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Coffee create(Coffee coffee) {
        return coffeeService.createCoffee(coffee);
    }

    @Path("/{id}")
    @DELETE
    @RolesAllowed({ "Admin", "User" })
    @Operation(
        summary = "Deletes a Coffee break.",
        description = "Deletes a Coffee break by its id."
    )
    public void delete(@PathParam("id") Long id) {
        coffeeService.deleteCoffee(id);
    }

    @Path("/{id}")
    @PUT
    @RolesAllowed({ "Admin", "User" })
    @Operation(
        summary = "Updates a coffee break.",
        description = "Updates a coffee break by its id."
    )
    public Coffee update(@PathParam("id") Long id, Coffee coffee) {
        return coffeeService.updateCoffee(id, coffee);
    }
}
