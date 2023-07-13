package com.example.bikerent;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public class BikeRepository {

    private final EntityManager entityManager;

    public BikeRepository(EntityManager entityManager) {
        this.entityManager = entityManager;

    }

    public void save(Bike bike){
        entityManager.persist(bike);
    }

    public Optional<Bike> findById(Long id){
        Bike bike = entityManager.find(Bike.class, id);
        return Optional.ofNullable(bike);
    }

    public void deleteById(Long id){
        findById(id).ifPresent(entityManager::remove);
    }
}
