package com.example.todo;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;



public class SimpleTaskRepository implements TaskRepository {

    private final Map<Long, Task> tasks = new HashMap<>();
    private static long nextId = 1;

    @Override
    public Task save(Task task) {
        task.setId(nextId);
        tasks.put(nextId, task);
        nextId++;
        return task;
    }

    @Override
    public Optional<Task> findById(Long id) {
        return Optional.ofNullable(tasks.get(id));
    }
}
