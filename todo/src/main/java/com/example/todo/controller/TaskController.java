package com.example.todo.controller;

import com.example.todo.dto.TaskDurationDto;
import com.example.todo.exception.TaskAlreadyStartedException;
import com.example.todo.exception.TaskAlreadyStoppedException;
import com.example.todo.exception.TaskNotStartedException;
import com.example.todo.model.Task;
import com.example.todo.dto.TaskDto;
import com.example.todo.service.TaskService;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
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
            case PRINT_NOT_STARTED_TASKS -> printNotStartedTasks();
            case PRINT_COMPLETED_TASKS -> printCompletedTasks();
            case PRINT_SINGLE -> printTask();
            case START_TASK -> startTask();
            case END_TASK -> endTask();
            case EXIT -> exit();
        }
    }

    private void printNotStartedTasks() {
        taskService.getAllNotStartedTasksInfo().forEach(System.out::println);
    }

    private void printCompletedTasks() {
        taskService.getAllCompletedTasksInfo().forEach(System.out::println);
    }

    private void endTask() {
        long taskId = getTaskId();
        try {
            TaskDurationDto taskDuration = taskService.endTask(taskId);
            System.out.println(taskDuration);
        } catch (TaskAlreadyStoppedException e){
            System.out.println("Zadanie zostało juz wczesniej zakończone");
        } catch (TaskNotStartedException e){
            System.out.println("Zadanie jeszcze nie wystartowało");
        }
    }

    private void startTask() {
        long taskId = getTaskId();
        try {
            LocalDateTime taskStartTime = taskService.startTask(taskId);
            System.out.println("Czas rozpoczęcia zadania: " + taskStartTime);
        } catch (TaskAlreadyStartedException e){
            System.out.println("Zadanie zostało juz wczesniej wystartowane");
        }
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
        Long savedTaskId = taskService.add(taskDto);
        System.out.println("Zadanie zapisano z id: " + savedTaskId);
    }

    private void printTask() {
        long taskId = getTaskId();
        taskService.getTaskInfo(taskId)
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
