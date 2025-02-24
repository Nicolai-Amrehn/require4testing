package com.example.require4testing.dto;

import java.time.LocalDateTime;

public record TestRunDTO(
        long id,
        String testCases,
        String tester,
        String title,
        String description,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
