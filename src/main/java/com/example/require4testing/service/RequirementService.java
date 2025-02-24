package com.example.require4testing.service;

import com.example.require4testing.dto.RequirementDTO;
import com.example.require4testing.model.Requirement;
import com.example.require4testing.repository.RequirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RequirementService {
    RequirementRepository requirementRepository;

    @Autowired
    public RequirementService(RequirementRepository requirementRepository) {
        this.requirementRepository = requirementRepository;
    }

    public List<RequirementDTO> findAllRequirements() {
        List<Requirement> requirements = requirementRepository.findAll();
        return requirements.stream().map(requirement -> new RequirementDTO(
                requirement.getId(),
                requirement.getTitle(),
                requirement.getProject(),
                requirement.getDescription(),
                requirement.getPriority(),
                requirement.getStatus(),
                requirement.getCreated_at(),
                requirement.getUpdated_at()
        )).collect(Collectors.toList());
    }

    public Requirement createRequirement(Requirement requirement) {
        return requirementRepository.save(requirement);
    }

}
