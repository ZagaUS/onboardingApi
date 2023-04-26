package com.zaga.employee_onboarding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zaga.employee_onboarding.entity.Skills;
import com.zaga.employee_onboarding.service.SkillsService;

@RestController
public class SkillsController {
    @Autowired
    SkillsService skillsService;

    @PostMapping("/skills")
    public ResponseEntity<Skills> createSkills(@RequestBody Skills skills) {
        Skills createSkills = skillsService.createSkills(skills);
        return ResponseEntity.ok(createSkills);
    }

    @GetMapping("/getAllSkills")
    public ResponseEntity<List<Skills>> getAllSkills() {
        try {
            List<Skills> getAllSkills = skillsService.getAllSkills();
            return ResponseEntity.ok(getAllSkills);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/getSkillsById")
    public ResponseEntity<Skills> getSkillsById(String employeeId) {
        try {
            Skills getSkillsById = skillsService.getSkillsById(employeeId);
            return ResponseEntity.ok(getSkillsById);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/updateSkills")
    public ResponseEntity<Skills> updateSkills(@RequestBody Skills skills) {
        String employeeId=skills.getEmployeeId();
        try {
            Skills updateSkills = skillsService.updateSkills(employeeId, skills);
            return ResponseEntity.ok(updateSkills);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
