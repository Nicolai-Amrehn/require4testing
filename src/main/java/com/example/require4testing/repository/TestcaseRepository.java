package com.example.require4testing.repository;

import com.example.require4testing.model.Testcase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestcaseRepository extends JpaRepository<Testcase, Long> {
}
