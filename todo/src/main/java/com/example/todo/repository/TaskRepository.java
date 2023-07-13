package com.example.todo.repository;

import com.example.todo.model.Task;

import java.util.Optional;

public interface TaskRepository {

    Task save(Task task);
    Optional<Task> findById(Long id);
}
