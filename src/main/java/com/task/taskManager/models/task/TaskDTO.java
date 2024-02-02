package com.task.taskManager.models.task;

import java.time.LocalDate;

public class TaskDTO {

    private String taskName;
    private String taskDescription;
    private LocalDate taskDate;
    private LocalDate taskEndDate;
    private String taskStatus;

    public TaskDTO() {
    }

    public TaskDTO(String taskName, String taskDescription, LocalDate taskDate, LocalDate taskEndDate, String taskStatus) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskDate = taskDate;
        this.taskEndDate = taskEndDate;
        this.taskStatus = taskStatus;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public LocalDate getTaskDate() {
        return taskDate;
    }

    public LocalDate getTaskEndDate() {
        return taskEndDate;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void setTaskDate(LocalDate taskDate) {
        this.taskDate = taskDate;
    }

    public void setTaskEndDate(LocalDate taskEndDate) {
        this.taskEndDate = taskEndDate;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }
}
