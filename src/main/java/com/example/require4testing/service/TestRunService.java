package com.example.require4testing.service;

import com.example.require4testing.dto.TestRunDTO;
import com.example.require4testing.model.TestRun;
import com.example.require4testing.repository.TestRunRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestRunService {
    TestRunRepository testRunRepository;

    public TestRunService(TestRunRepository testRunRepository) {
        this.testRunRepository = testRunRepository;
    }

    public List<TestRunDTO> findAllTestRuns() {
        List<TestRun> testRuns = testRunRepository.findAll();
        return testRuns.stream().map(testRun -> new TestRunDTO(
                testRun.getId(),
                testRun.getTestCases(),
                testRun.getTester(),
                testRun.getTitle(),
                testRun.getDescription(),
                testRun.getCreated_at(),
                testRun.getUpdated_at()
        )).collect(Collectors.toList());
    }
}
