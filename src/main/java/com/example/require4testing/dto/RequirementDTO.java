package com.example.require4testing.dto;


import java.time.LocalDateTime;

public record RequirementDTO(
        Long id,
        String title,
        String description,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}