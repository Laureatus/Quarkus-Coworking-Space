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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.model.Booking;
import ch.zli.m223.service.AuthService;
import ch.zli.m223.service.BookingService;

@Path("/booking")
@Tag(name = "Bookings", description = "Handling of bookings")
public class BookingController {

    @Inject
    BookingService bookingService;

    @Inject
    AuthService authService;

    @GET
    @RolesAllowed({ "Admin", "User" })
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "Index all bookings.", 
        description = "Returns a list of all bookings."
    )
    public List<Booking> index(@Context SecurityContext ctx) {
        if (ctx.isUserInRole("Admin")) {
            return bookingService.findAll();
        }
        return bookingService.findUserBookings();
    }
    
    @POST
    @RolesAllowed({ "Admin", "User" })
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "Index all bookings.", 
        description = "Returns a list of all bookings."
    )
    public Booking create(Booking booking) {
        return bookingService.createBooking(booking);
    }

    @Path("/{id}")
    @DELETE
    @RolesAllowed({ "Admin", "User" })
    @Operation(
        summary = "Deletes a bookign.",
        description = "Deletes a booking by its id."
    )
    public void delete(@PathParam("id") Long id) {
        bookingService.deleteBooking(id);
    }

    @Path("/{id}")
    @PUT
    @RolesAllowed({ "Admin", "User" })
    @Operation(
        summary = "Updates a booking.",
        description = "Updates a booking by its id."
    )
    public Booking update(@PathParam("id") Long id, Booking booking) {
        return bookingService.updateBooking(id, booking);
    }
}