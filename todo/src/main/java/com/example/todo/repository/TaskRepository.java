package com.example.todo.repository;

import com.example.todo.model.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {

    List<Task> findAllByStartTimeIsNullOrderByPriorityDesc();

    List<Task> findAllByCompletionTimeIsNotNullOrderByCompletionTimeDesc();
}
