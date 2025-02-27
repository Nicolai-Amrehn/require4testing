package com.example.require4testing.controller;

import com.example.require4testing.dto.TestRunDTO;
import com.example.require4testing.model.TestRun;
import com.example.require4testing.service.TestRunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TestRunController {
    TestRunService testRunService;

    @Autowired
    public TestRunController(TestRunService testRunService) {
        this.testRunService = testRunService;
    }

    @GetMapping("/testruns")
    public String testRun(Model model) {
        List<TestRunDTO> testRuns = testRunService.findAllTestRuns();
        model.addAttribute("testruns", testRuns);
        return "testruns";
    }

    @GetMapping("/testruns/add")
    public String addTestRun(Model model) {
        model.addAttribute("testrun", new TestRun());
        return "testruns-add";
    }
    @PostMapping("/testruns/add")
    public String addTestRun(@ModelAttribute TestRun testRun, Model model) {
        testRunService.createTestRun(testRun);
        return "redirect:/testruns";
    }
}
