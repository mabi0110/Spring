package com.example.todo.service;


import com.example.todo.dto.TaskDurationDto;
import com.example.todo.exception.TaskAlreadyStoppedException;
import com.example.todo.exception.TaskNotFoundException;
import com.example.todo.exception.TaskAlreadyStartedException;
import com.example.todo.exception.TaskNotStartedException;
import com.example.todo.model.Task;
import com.example.todo.dto.TaskDto;
import com.example.todo.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TaskService {

    private static long nextId = 1;
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Transactional
    public Long add(TaskDto taskDto) {
        Task task = new Task(
                taskDto.getTitle(),
                taskDto.getDescription(),
                taskDto.getPriority());
        task.setId(nextId);
        Task savedTask = taskRepository.save(task);
        nextId++;
        return savedTask.getId();
    }


    public Optional<String> getTaskInfo(Long taskId) {
        return taskRepository.findById(taskId).map(Task::toString);
    }


    @Transactional
    public TaskDurationDto endTask(Long taskId) {
        LocalDateTime endTime = LocalDateTime.now();
        Task task = taskRepository.findById(taskId)
                .orElseThrow(TaskNotFoundException::new);
        if (task.getStartTime() == null) {
            throw new TaskNotStartedException();
        } else if (task.getCompletionTime() != null) {
            throw new TaskAlreadyStoppedException();
        }
        task.setCompletionTime(endTime);
        return new TaskDurationDto(task.getStartTime(), task.getCompletionTime());
    }

    @Transactional
    public LocalDateTime startTask(Long taskId) {
        LocalDateTime startTime = LocalDateTime.now();
        Task task = taskRepository.findById(taskId)
                .orElseThrow(TaskNotFoundException::new);
        if (task.getStartTime() != null) {
            throw new TaskAlreadyStartedException();
        }
        task.setStartTime(startTime);
        return task.getStartTime();
    }

}
