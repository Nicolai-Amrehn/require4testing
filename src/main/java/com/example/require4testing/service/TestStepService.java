package com.example.require4testing.service;

import com.example.require4testing.dto.TestStepDTO;
import com.example.require4testing.model.TestStep;
import com.example.require4testing.repository.TestStepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestStepService {
    TestStepRepository teststepRepository;

    @Autowired
    public TestStepService(TestStepRepository teststepRepository) {
        this.teststepRepository = teststepRepository;
    }

    public List<TestStepDTO> findAllTeststeps() {
        List<TestStep> testSteps = teststepRepository.findAll();
        return testSteps.stream().map(testStep -> new TestStepDTO(
                testStep.getId(),
                testStep.getTestcase(),
                testStep.getStep(),
                testStep.getTitle(),
                testStep.getDescription()
        )).collect(Collectors.toList());
    }

    public TestStep createTestStep(TestStep testStep) {
        return teststepRepository.save(testStep);
    }
}
