package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Coffee;

@ApplicationScoped
public class CoffeeService {
    @Inject
    EntityManager entityManager;

    public List<Coffee> findAll() {
        var query = entityManager.createQuery("FROM Coffee", Coffee.class);
        return query.getResultList();
    }

    @Transactional
    public Coffee createCoffee(Coffee coffee) {
        return entityManager.merge(coffee);
    }

    @Transactional
    public void deleteCoffee(Long id) {
        var coffee = entityManager.find(Coffee.class, id);
        entityManager.remove(coffee);
    }

    @Transactional
    public Coffee updateCoffee(Long id, Coffee coffee) {
        coffee.setId(id);
        return entityManager.merge(coffee);
    }
}
