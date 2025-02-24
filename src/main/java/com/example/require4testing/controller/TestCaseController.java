package com.example.require4testing.controller;

import com.example.require4testing.dto.TestCaseDTO;
import com.example.require4testing.model.TestCase;
import com.example.require4testing.service.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TestCaseController {
    TestCaseService testcaseService;

    @Autowired
    public TestCaseController(TestCaseService testcaseService) {
        this.testcaseService = testcaseService;
    }

    @GetMapping("/testcases")
    public String testcase(Model model) {
        List<TestCaseDTO> testcases = testcaseService.findAllTestcases();
        model.addAttribute("testcases", testcases);
        model.addAttribute("testcase", new TestCase());
        return "testcases";
    }
}
