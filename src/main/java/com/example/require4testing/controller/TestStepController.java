package com.example.require4testing.controller;

import com.example.require4testing.dto.TestCaseDTO;
import com.example.require4testing.dto.TestStepDTO;
import com.example.require4testing.model.TestStep;
import com.example.require4testing.service.TestCaseService;
import com.example.require4testing.service.TestStepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TestStepController {
    TestStepService teststepService;
    TestCaseService testCaseService;

    @Autowired
    public TestStepController(TestStepService teststepService, TestCaseService testCaseService) {
        this.teststepService = teststepService;
        this.testCaseService = testCaseService;
    }

    @GetMapping("/teststeps")
    public String teststeps(Model model) {
        List<TestStepDTO> teststeps = teststepService.findAllTeststeps();
        model.addAttribute("teststeps", teststeps);
        return "teststeps";
    }

    @GetMapping("/teststeps/add")
    public String addTestStep(Model model) {
        List<TestCaseDTO> testcases = testCaseService.findAllTestcases();
        model.addAttribute("testcases", testcases);
        model.addAttribute("teststep", new TestStep());
        return "teststeps-add";
    }

    @PostMapping("/teststeps/add")
    public String addTestStep(@ModelAttribute("teststep") TestStep teststep, Model model) {
        teststepService.createTestStep(teststep);
        return "redirect:/teststeps";
    }
}
