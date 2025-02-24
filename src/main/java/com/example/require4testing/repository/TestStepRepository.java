package com.example.require4testing.repository;

import com.example.require4testing.model.TestStep;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestStepRepository extends JpaRepository<TestStep, Long> {
}
