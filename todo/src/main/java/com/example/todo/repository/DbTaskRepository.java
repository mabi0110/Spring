package com.example.todo.repository;

import com.example.todo.model.Task;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class DbTaskRepository implements TaskRepository {

    private final EntityManager entityManager;
    private static long nextId = 1;

    public DbTaskRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Task save(Task task) {
        task.setId(nextId);
        entityManager.persist(task);
        nextId++;
        return task;
    }

    @Override
    public Optional<Task> findById(Long id) {
        Task task = entityManager.find(Task.class, id);
        return Optional.ofNullable(task);
    }
}
