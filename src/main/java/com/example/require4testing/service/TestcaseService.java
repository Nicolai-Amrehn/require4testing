package com.example.require4testing.service;

import com.example.require4testing.dto.TestcaseDTO;
import com.example.require4testing.model.Testcase;
import com.example.require4testing.repository.TestcaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestcaseService {
    TestcaseRepository testcaseRepository;

    @Autowired
    public TestcaseService(TestcaseRepository testcaseRepository) {
        this.testcaseRepository = testcaseRepository;
    }

    public List<TestcaseDTO> findAllTestcases() {
        List<Testcase> testcases = testcaseRepository.findAll();
        return testcases.stream().map(testcase -> new TestcaseDTO(
                testcase.getId(),
                testcase.getRequirement(),
                testcase.getTester(),
                testcase.getTitle(),
                testcase.getDescription(),
                testcase.getTestStatus(),
                testcase.getTestResult(),
                testcase.getCreated_at(),
                testcase.getUpdated_at()
        )).collect(Collectors.toList());
    }
}
