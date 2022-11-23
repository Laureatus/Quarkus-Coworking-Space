package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;



import ch.zli.m223.model.Material;

@ApplicationScoped
public class MaterialService {
    
    @Inject
    EntityManager entityManager;

    public List<Material> findAll() {
        var query = entityManager.createQuery("FROM Material", Material.class);
        return query.getResultList();
    }

    @Transactional
    public Material createMaterial(Material material) {
        entityManager.persist(material);
        return material;
    }

    @Transactional
    public void deleteMaterial(Long id) {
        var material = entityManager.find(Material.class, id);
        entityManager.remove(material);
    }

    @Transactional
    public Material updateMaterial(Long id, Material material) {
        material.setId(id);
        return entityManager.merge(material);
    }
}
