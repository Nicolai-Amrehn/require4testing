package com.example.require4testing.dto;

import com.example.require4testing.model.TestCase;

public record TestStepDTO(
        long id,
        TestCase testcase,
        int step,
        String title,
        String description
) {
}
