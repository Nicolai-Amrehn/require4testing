package com.example.require4testing.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Requirement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String project;
    private String description;
    private String priority;
    private String status;
    @OneToMany(mappedBy = "requirement", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TestCase> testCases;
    @CreationTimestamp
    private LocalDateTime created_at;
    @UpdateTimestamp
    private LocalDateTime updated_at;

    public Requirement(long id, String title, String project, String description, String priority, String status, LocalDateTime created_at, LocalDateTime updated_at) {
        this.id = id;
        this.title = title;
        this.project = project;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Requirement() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }
}
