package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.ApplicationUser;

@ApplicationScoped
public class ApplicationUserService {
    @Inject
    EntityManager entityManager;

    public List<ApplicationUser> findAll() {
        var query = entityManager.createQuery("FROM ApplicationUser", ApplicationUser.class);
        return query.getResultList();
    }

    @Transactional
    public ApplicationUser createUser(ApplicationUser applicationUser) {
        return entityManager.merge(applicationUser);
    }

    @Transactional
    public void deleteUser(Long id) {
        var applicationUser = entityManager.find(ApplicationUser.class, id);
        entityManager.remove(applicationUser);
    }

    @Transactional
    public ApplicationUser updateUser(Long id, ApplicationUser applicationUser) {
        applicationUser.setId(id);
        return entityManager.merge(applicationUser);
    }
    
}
