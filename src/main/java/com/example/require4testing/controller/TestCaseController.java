package com.example.require4testing.controller;

import com.example.require4testing.dto.RequirementDTO;
import com.example.require4testing.dto.TestCaseDTO;
import com.example.require4testing.model.TestCase;
import com.example.require4testing.model.TestResult;
import com.example.require4testing.model.TestStatus;
import com.example.require4testing.repository.TestCaseRepository;
import com.example.require4testing.service.RequirementService;
import com.example.require4testing.service.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TestCaseController {
    private final TestCaseService testCaseService;
    private final TestCaseRepository testCaseRepository;
    TestCaseService testcaseService;
    RequirementService requirementService;

    @Autowired
    public TestCaseController(TestCaseService testcaseService, RequirementService requirementService, TestCaseService testCaseService, TestCaseRepository testCaseRepository) {
        this.testcaseService = testcaseService;
        this.requirementService = requirementService;
        this.testCaseService = testCaseService;
        this.testCaseRepository = testCaseRepository;
    }

    @GetMapping("/testcases")
    public String testcase(Model model) {
        List<TestCaseDTO> testcases = testcaseService.findAllTestcases();
        model.addAttribute("testcases", testcases);

        List<RequirementDTO> requirements = requirementService.findAllRequirements();
        model.addAttribute("requirements", requirements);

        model.addAttribute("TestStatuses", TestStatus.values());
        model.addAttribute("TestResults", TestResult.values());

        model.addAttribute("testcase", new TestCase());
        return "testcases";
    }

    @PostMapping("/testcases/add")
    public String addTestCase(@ModelAttribute TestCase testCase, Model model) {
        testCaseService.createTestCase(testCase);
        return "redirect:/testcases";
    }
}
