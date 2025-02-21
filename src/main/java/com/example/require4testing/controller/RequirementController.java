package com.example.require4testing.controller;

import com.example.require4testing.dto.RequirementDTO;
import com.example.require4testing.service.RequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
        model.addAttribute("requirement", new RequirementDTO(null, "", "", null, null));
        return "requirements";
    }
}
