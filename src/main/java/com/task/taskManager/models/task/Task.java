package com.task.taskManager.models.task;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.task.taskManager.models.user.ApplicationUser;
import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;

import java.time.LocalDate;

@Entity
@Table(name =  "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer taskId;
    private String taskName;
    private String taskDescription;
    private LocalDate taskDate;
    private LocalDate taskEndDate;
    private String taskStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_name")
    @JsonIgnore
    private ApplicationUser user;

    public ApplicationUser getUser() {
        return user;
    }

    public void setUser(ApplicationUser user) {
        this.user = user;
    }

    public Task() {
    }

    public Task(Integer taskId, String taskName, String taskDescription, LocalDate taskDate, LocalDate taskEndDate, String taskStatus) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskDate = taskDate;
        this.taskEndDate = taskEndDate;
        this.taskStatus = taskStatus;
    }

    public Integer getTaskId() {
        return taskId;
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

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
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
