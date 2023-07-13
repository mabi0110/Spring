package com.example.todo.service;


import com.example.todo.exception.TaskAlreadyStoppedException;
import com.example.todo.exception.TaskNotFoundException;
import com.example.todo.exception.TaskAlreadyStartedException;
import com.example.todo.model.Task;
import com.example.todo.model.TaskDto;
import com.example.todo.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TaskService {


    private final TaskRepository taskRepository;


    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Transactional
    public Task add(TaskDto taskDto) {
        Task task = new Task(
                taskDto.getTitle(),
                taskDto.getDescription(),
                taskDto.getPriority());
        taskRepository.save(task);
        return task;
    }


    public Optional<Object> findById(long taskId) {
        return Optional.ofNullable(taskRepository.findById(taskId));
    }


    @Transactional
    public void endTask(Long taskId) {
        LocalDateTime endTime = LocalDateTime.now();
        updateTaskEndTime(taskId, endTime);

    }

    private Task updateTaskEndTime(Long taskId, LocalDateTime endTime) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(TaskNotFoundException::new);
        if (task.getCompletionTime() != null) {
            throw new TaskAlreadyStoppedException();
        } else {
            task.setCompletionTime(endTime);
        }
        return task;
    }

    @Transactional
    public void startTask(Long taskId) {
        LocalDateTime startTime = LocalDateTime.now();
        updateTaskStartTime(taskId, startTime);
    }

    private Task updateTaskStartTime(Long taskId, LocalDateTime startTime) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(TaskNotFoundException::new);
        if (task.getStartTime() != null) {
            throw new TaskAlreadyStartedException();
        } else {
            task.setStartTime(startTime);
        }
        return task;
    }

}
