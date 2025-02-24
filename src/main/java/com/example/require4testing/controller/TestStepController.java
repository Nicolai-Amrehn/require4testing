package com.example.require4testing.controller;

import com.example.require4testing.dto.TestStepDTO;
import com.example.require4testing.model.TestStep;
import com.example.require4testing.service.TestStepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TestStepController {
    TestStepService teststepService;

    @Autowired
    public TestStepController(TestStepService teststepService) {
        this.teststepService = teststepService;
    }

    @GetMapping("/teststeps")
    public String teststeps(Model model) {
        List<TestStepDTO> teststeps = teststepService.findAllTeststeps();
        model.addAttribute("teststeps", teststeps);
        model.addAttribute("teststep", new TestStep());
        return "teststeps";
    }
}
