package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.eclipse.microprofile.jwt.Claims;
import org.eclipse.microprofile.jwt.JsonWebToken;

import ch.zli.m223.model.Booking;

@ApplicationScoped
public class BookingService {

    @Inject
    EntityManager entityManager;

    @Inject
    JsonWebToken jwt;

    public List<Booking> findAll() {
        var query = entityManager.createQuery("FROM Booking", Booking.class);
        return query.getResultList();
    }

    public List<Booking> findUserBookings() {
        var query = entityManager.createQuery("FROM Booking where user_id =" + jwt.getClaim(Claims.given_name), Booking.class);
        return query.getResultList();
    }

    @Transactional
    public Booking createBooking(Booking booking) {
        return entityManager.merge(booking);
    }

    @Transactional
    public void deleteBooking(Long id) {
        var Booking = entityManager.find(Booking.class, id);
        entityManager.remove(Booking);
    }

    @Transactional
    public Booking updateBooking(Long id, Booking booking) {
        booking.setId(id);
        return entityManager.merge(booking);
    }
    
}
