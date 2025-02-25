package com.example.require4testing.controller;

import com.example.require4testing.dto.RequirementDTO;
import com.example.require4testing.model.Requirement;
import com.example.require4testing.service.RequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class RequirementController {
    private final RequirementService requirementService;

    @Autowired
    public RequirementController(RequirementService requirementService) {
        this.requirementService = requirementService;
    }

    @GetMapping("/requirements")
    public String requirements(Model model) {
        List<RequirementDTO> requirements = requirementService.findAllRequirements();
        model.addAttribute("requirements", requirements);
        model.addAttribute("requirement", new Requirement());
        return "requirements";
    }

    @PostMapping("/requirements/add")
    public String createRequirement(@ModelAttribute("requirement") Requirement requirement) {
    requirementService.createRequirement(requirement);
    return "redirect:/requirements";
    }
}
