package com.example.require4testing.controller;

import com.example.require4testing.dto.RequirementDTO;
import com.example.require4testing.dto.TestCaseDTO;
import com.example.require4testing.model.TestCase;
import com.example.require4testing.model.TestResult;
import com.example.require4testing.model.TestStatus;
import com.example.require4testing.service.RequirementService;
import com.example.require4testing.service.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TestCaseController {
    private final TestCaseService testCaseService;
    TestCaseService testcaseService;
    RequirementService requirementService;

    @Autowired
    public TestCaseController(TestCaseService testcaseService, RequirementService requirementService, TestCaseService testCaseService) {
        this.testcaseService = testcaseService;
        this.requirementService = requirementService;
        this.testCaseService = testCaseService;
    }

    @GetMapping("/testcases")
    public String testcase(Model model) {
        List<TestCaseDTO> testcases = testcaseService.findAllTestcases();
        model.addAttribute("testcases", testcases);
        return "testcases";
    }

    @GetMapping("/testcases/add")
    public String testcaseAdd(Model model) {
        List<RequirementDTO> requirements = requirementService.findAllRequirements();
        model.addAttribute("requirements", requirements);
        model.addAttribute("testcase", new TestCase());
        model.addAttribute("TestStatuses", TestStatus.values());
        model.addAttribute("TestResults", TestResult.values());
        return "testcases-add";
    }

    @PostMapping("/testcases/add")
    public String addTestCase(@ModelAttribute TestCase testCase, Model model) {
        testCaseService.createTestCase(testCase);
        return "redirect:/testcases";
    }

    @GetMapping("/testcases/edit/{id}")
    public String testcaseEdit(@PathVariable Long id, Model model) {
        TestCase testCase = testCaseService.findTestCaseById(id);
        model.addAttribute("testCase", testCase);
        List<RequirementDTO> requirements = requirementService.findAllRequirements();
        model.addAttribute("requirements", requirements);
        model.addAttribute("TestStatuses", TestStatus.values());
        model.addAttribute("TestResults", TestResult.values());
        return "testcases-edit";
    }

    @PostMapping("/testcases/edit/{id}")
    public String editTestCase(@ModelAttribute TestCase testCase) {
        testCaseService.updateTestCase(testCase);
        return "redirect:/testcases";
    }

    @PostMapping("/testcases/delete/{id}")
    public String deleteTestCase(@PathVariable Long id) {
        testCaseService.deleteTestCase(id);
        return "redirect:/testcases";
    }
}
