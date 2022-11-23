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



import ch.zli.m223.model.Material;
import ch.zli.m223.service.MaterialService;

@Path("/material")
@Tag(name = "Material", description = "Handling of material")
public class MaterialController {
    
    @Inject
    MaterialService materialService;

    @GET
    @RolesAllowed({ "Admin" , "User"})
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "Index all material Breaks.", 
        description = "Returns a list of all material s."
    )
    public List<Material> index() {
        return materialService.findAll();
    }

    @POST
    @RolesAllowed({ "Admin", "User" })
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Material create(Material material) {
        return materialService.createMaterial(material);
    }

    @Path("/{id}")
    @DELETE
    @RolesAllowed({ "Admin", "User" })
    @Operation(
        summary = "Deletes a material .",
        description = "Deletes a material  by its id."
    )
    public void delete(@PathParam("id") Long id) {
        materialService.deleteMaterial(id);
    }

    @Path("/{id}")
    @PUT
    @RolesAllowed({ "Admin", "User" })
    @Operation(
        summary = "Updates a material .",
        description = "Updates a material  by its id."
    )
    public Material update(@PathParam("id") Long id, Material material) {
        return materialService.updateMaterial(id, material);
    }
}
