package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;

import com.oracle.svm.core.annotate.Inject;

import ch.zli.m223.model.ApplicationUser;

@ApplicationScoped
public class ApplicationUserService {
    @Inject
    EntityManager entityManager;

    public List<ApplicationUser> findAll() {
        var query = entityManager.createQuery("FROM Entry", ApplicationUser.class);
        return query.getResultList();
    }
    
}
