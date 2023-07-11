package com.example.todo;

import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class TaskController {

    private final TaskRepository taskRepository = new SimpleTaskRepository();
    private final Scanner scanner;

    public TaskController(Scanner scanner) {
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
            case EXIT -> exit();
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
        Task task = new Task(title, description, priority);
        Task savedTask = taskRepository.save(task);
        System.out.println("Zadanie zapisano z id: " + savedTask.getId());
    }

    private void printTask() {
        System.out.println("Podaj id zadania: ");
        long taskId = scanner.nextLong();
        scanner.nextLine();
        taskRepository.findById(taskId)
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Brak wpisu o takim id")
                );
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
