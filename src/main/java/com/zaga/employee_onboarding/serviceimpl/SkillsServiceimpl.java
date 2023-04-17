package com.zaga.employee_onboarding.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaga.employee_onboarding.entity.Skills;
import com.zaga.employee_onboarding.repository.SkillsRepo;
import com.zaga.employee_onboarding.service.SkillsService;

@Service
public class SkillsServiceimpl implements SkillsService {
    @Autowired
    SkillsRepo skillsRepo;
    
    @Override
    public Skills createSkills(Skills skills) {
        Skills skills2 = skillsRepo.save(skills);
        return skills2;
    }

    @Override
    public List<Skills> getAllSkills() {

        List<Skills> getSkills = skillsRepo.findAll();
        return getSkills;

    }

    @Override
    public Skills getSkillsById(String employeeId) {
        Skills getSkills = skillsRepo.findById(employeeId).get();
        return getSkills;
    }
}
