package com.example.todo;

import java.util.Optional;

public interface TaskRepository {

    Task save(Task task);
    Optional<Task> findById(Long id);
}
