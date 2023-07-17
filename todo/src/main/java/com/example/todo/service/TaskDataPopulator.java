package com.example.todo.service;

import com.example.todo.dto.TaskDto;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class TaskDataPopulator {

    private TaskService taskService;

    public TaskDataPopulator(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostConstruct
    void populateTestData() {
        taskService.add(new TaskDto("Nauka Springa", "Nauczyć się obsługiwać bazy danych w Springu", 90));
        taskService.add(new TaskDto("Poprawić budżet domowy", "Sprawdzić arkusz, który błędnie liczy budżet domowy", 50));
        taskService.add(new TaskDto("Auto do mechanika", "Umówić i zawieźć auto do mechanika na przegląd", 80));
        taskService.add(new TaskDto("Zaplanować wakacje", "Wyszukać i zaklepać wakacje w biurze podróży", 70));
        taskService.add(new TaskDto("Kupić farbę", "Kupić białą farbę do odmalowania mieszkania", 30));
        taskService.startTask(1L);
        taskService.endTask(1L);
        taskService.startTask(3L);
        taskService.endTask(3L);
    }
}
