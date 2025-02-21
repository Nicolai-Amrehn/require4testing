package com.example.require4testing.repository;

import com.example.require4testing.model.Requirement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RequirementRepository extends JpaRepository<Requirement, Long> {
    Optional<Requirement> findByTitle(String title);
}
