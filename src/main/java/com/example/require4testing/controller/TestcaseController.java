package com.example.require4testing.controller;

import com.example.require4testing.dto.TestcaseDTO;
import com.example.require4testing.model.Testcase;
import com.example.require4testing.service.TestcaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TestcaseController {
    TestcaseService testcaseService;

    @Autowired
    public TestcaseController(TestcaseService testcaseService) {
        this.testcaseService = testcaseService;
    }

    @GetMapping("/testcases")
    public String testcase(Model model) {
        List<TestcaseDTO> testcases = testcaseService.findAllTestcases();
        model.addAttribute("testcases", testcases);
        model.addAttribute("testcase", new Testcase());
        return "testcases";
    }
}
