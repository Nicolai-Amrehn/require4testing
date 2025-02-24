package com.example.require4testing.service;

import com.example.require4testing.dto.TestCaseDTO;
import com.example.require4testing.model.TestCase;
import com.example.require4testing.repository.TestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestCaseService {
    TestCaseRepository testcaseRepository;

    @Autowired
    public TestCaseService(TestCaseRepository testcaseRepository) {
        this.testcaseRepository = testcaseRepository;
    }

    public List<TestCaseDTO> findAllTestcases() {
        List<TestCase> testCases = testcaseRepository.findAll();
        return testCases.stream().map(testcase -> new TestCaseDTO(
                testcase.getId(),
                testcase.getRequirement(),
                testcase.getTitle(),
                testcase.getDescription(),
                testcase.getTestStatus(),
                testcase.getTestResult(),
                testcase.getCreated_at(),
                testcase.getUpdated_at()
        )).collect(Collectors.toList());
    }
}
