package com.example.todo.controller;

import com.example.todo.model.Task;
import com.example.todo.model.TaskDto;
import com.example.todo.service.TaskService;
import org.springframework.stereotype.Controller;

import java.util.Optional;
import java.util.Scanner;

@Controller
public class TaskController {

    private final TaskService taskService;
    private final Scanner scanner;

    public TaskController(TaskService taskService, Scanner scanner) {
        this.taskService = taskService;
        this.scanner = scanner;
    }

    public void loop() {
        Option option;
        do {
            printOptions();
            option = chooseOption();
            evaluateOption(option);
        } while (option != Option.EXIT);
    }

    private void evaluateOption(Option option) {
        switch (option) {
            case ADD -> addTask();
            case PRINT_SINGLE -> printTask();
            case START_TASK -> startTask();
            case END_TASK -> endTask();
            
            case EXIT -> exit();
        }
    }

    private void endTask() {
        long taskId = getTaskId();
        taskService.endTask(taskId);
    }

    private void startTask() {
        long taskId = getTaskId();
        taskService.startTask(taskId);


    }

    private void addTask() {
        System.out.println("Podaj tytuł zadania: ");
        String title = scanner.nextLine();
        System.out.println("Opis zadania: ");
        String description = scanner.nextLine();
        System.out.println("Priorytet (wyzsza liczba = wyzszy priorytet): ");
        int priority = scanner.nextInt();
        scanner.nextLine();
        TaskDto taskDto = new TaskDto(title, description, priority);
        Task savedTask = taskService.add(taskDto);
        System.out.println("Zadanie zapisano z id: " + savedTask.getId());
    }

    private void printTask() {
        long taskId = getTaskId();
        taskService.findById(taskId)
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Brak wpisu o takim id")
                );
    }

    private long getTaskId() {
        System.out.println("Podaj id zadania: ");
        long taskId = scanner.nextLong();
        scanner.nextLine();
        return taskId;
    }

    private void exit() {
        System.out.println("Koniec programu");
    }

    private Option chooseOption() {
        int optionNumber = scanner.nextInt();
        scanner.nextLine();
        return Option.fromInt(optionNumber);
    }

    private void printOptions() {
        System.out.println("Wybierz opcję: ");
        Option[] options = Option.values();
        for (Option option : options) {
            System.out.println(option);
        }
    }
}
