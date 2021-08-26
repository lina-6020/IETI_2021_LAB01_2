package eci.edu.ieti.labUnoParteDos.dto;

import eci.edu.ieti.labUnoParteDos.datos.Status;

import java.time.LocalDateTime;

public class TaskDto {
    private String name;
    private String description;
    private Status status;
    private String assignedTo;
    private LocalDateTime dueDate;
    private Boolean created;

    public TaskDto() {
    }

    public TaskDto(String name, String description, Status status, String assignedTo, LocalDateTime dueDate, Boolean created) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.assignedTo = assignedTo;
        this.dueDate = dueDate;
        this.created = created;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public Boolean getCreated() {
        return created;
    }

    public void setCreated(Boolean created) {
        this.created = created;
    }
}
