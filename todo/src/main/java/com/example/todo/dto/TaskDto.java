package com.example.todo.dto;

public class TaskDto {
    public String title;
    public String description;
    public int priority;

    public TaskDto(String title, String description, int priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
    }


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

}
