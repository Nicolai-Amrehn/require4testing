package com.example.require4testing.dto;

import com.example.require4testing.model.Requirement;
import com.example.require4testing.model.TestResult;
import com.example.require4testing.model.TestStatus;

import java.time.LocalDateTime;

public record TestcaseDTO(
        long id,
        Requirement requirement,
        String tester,
        String title,
        String description,
        TestStatus testStatus,
        TestResult testResult,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {
}
