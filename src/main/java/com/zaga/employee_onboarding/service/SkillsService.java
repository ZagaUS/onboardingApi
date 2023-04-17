package com.zaga.employee_onboarding.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zaga.employee_onboarding.entity.Skills;

@Service
public interface SkillsService {
    
    public Skills createSkills(Skills skills);

    public List<Skills> getAllSkills();

    public Skills getSkillsById(String employeeId);

}
