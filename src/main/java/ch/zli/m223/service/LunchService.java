package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Lunch;

@ApplicationScoped
public class LunchService {

    @Inject
    EntityManager entityManager;

    public List<Lunch> findAll() {
        var query = entityManager.createQuery("FROM Lunch", Lunch.class);
        return query.getResultList();
    }

    @Transactional
    public Lunch createLunch(Lunch lunch) {
        return entityManager.merge(lunch);
    }

    @Transactional
    public void deleteLunch(Long id) {
        var lunch = entityManager.find(Lunch.class, id);
        entityManager.remove(lunch);
    }

    @Transactional
    public Lunch updateLunch(Long id, Lunch lunch) {
        lunch.setId(id);
        return entityManager.merge(lunch);
    }
    
}
