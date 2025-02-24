package com.example.require4testing.dto;


import java.time.LocalDateTime;

public record RequirementDTO(
        Long id,
        String title,
        String project,
        String description,
        String priority,
        String status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}