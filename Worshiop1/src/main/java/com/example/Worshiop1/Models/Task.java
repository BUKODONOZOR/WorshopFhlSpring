package com.example.Worshiop1.Models;

import com.example.Worshiop1.Enum.TaskStatus;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 255, nullable = true)
    private String description;

    @Column(nullable = false)
    private LocalDate dateCreation;

    @Column(nullable = false)
    private LocalTime timeCreation;

    @Enumerated(EnumType.STRING)
    @Column(length = 50, nullable = false)
    private TaskStatus status;

    // Constructor predeterminado que inicializa la fecha y la hora de creación
    public Task() {
        this.dateCreation = LocalDate.now();
        this.timeCreation = LocalTime.now();
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dateCreation=" + dateCreation +
                ", timeCreation=" + timeCreation +
                ", status=" + status +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public LocalTime getTimeCreation() {
        return timeCreation;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public void setTimeCreation(LocalTime timeCreation) {
        this.timeCreation = timeCreation;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    // Constructor con parámetros
    public Task(long id, String title, String description, LocalDate dateCreation, LocalTime timeCreation, TaskStatus status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dateCreation = dateCreation;
        this.timeCreation = timeCreation;
        this.status = status;
    }
}

