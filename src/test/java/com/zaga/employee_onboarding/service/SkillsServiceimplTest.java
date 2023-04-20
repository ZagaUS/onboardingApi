package com.zaga.employee_onboarding.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.zaga.employee_onboarding.entity.Skills;
import com.zaga.employee_onboarding.repository.SkillsRepo;
import com.zaga.employee_onboarding.serviceimpl.SkillsServiceimpl;

@ExtendWith(MockitoExtension.class)
public class SkillsServiceimplTest {
    
    @Mock
    SkillsRepo skillsRepo;

    @InjectMocks
    SkillsServiceimpl skillsServiceimpl;

    public Skills sharanya;
    public Skills pavithra;

    @BeforeEach
    void init() {
        sharanya = new Skills();
        sharanya.setEmployeeId("1");
        sharanya.setEmployeeName("Sharanya");
        List<String> skillsName = Arrays.asList("Java", "Javascript");
        sharanya.setSkillsName(skillsName);
        List<String> toolsName = Arrays.asList("Visual Studio Code", "Postman", "GitHub");
        sharanya.setToolsName(toolsName);
        sharanya.setYearsOfExperience("1");
        sharanya.setCompentencyLevel("Intermediate");

        pavithra = new Skills();
        pavithra.setEmployeeId("2");
        pavithra.setEmployeeName("Pavithra");
        List<String> skillsName1 = Arrays.asList("Java", "Javascript");
        pavithra.setSkillsName(skillsName1);
        List<String> toolsName1 = Arrays.asList("Visual Studio Code", "Postman", "GitHub");
        pavithra.setToolsName(toolsName1);
        pavithra.setYearsOfExperience("1");
        pavithra.setCompentencyLevel("Intermediate");

    }

    @Test
    void createSkills() {
        when(skillsRepo.save(any(Skills.class))).thenReturn(sharanya);

        Skills skills = skillsServiceimpl.createSkills(sharanya);

        assertNotNull(skills);
        assertThat(skills.getEmployeeId()).isEqualTo("1");

    }

    @Test
    void getAllSkills() {
        List<Skills> skills = new ArrayList<>();
        skills.add(sharanya);
        skills.add(pavithra);

        when(skillsRepo.findAll()).thenReturn(skills);

        List<Skills> skillsList = skillsServiceimpl.getAllSkills();

        assertEquals(2, skillsList.size());
        assertNotNull(skillsList);
        
    }

    @Test
    void getSkillsById() {
        when(skillsRepo.findById(anyString())).thenReturn(Optional.of(sharanya));

        Skills skills = skillsServiceimpl.getSkillsById(sharanya.getEmployeeId());

        assertNotNull(skills);
        assertThat(skills.getEmployeeId()).isEqualTo("1");
    }

    @Test
    void updateSkills() {
        when(skillsRepo.findById(anyString())).thenReturn(Optional.of(sharanya));

        when(skillsRepo.save(any(Skills.class))).thenReturn(sharanya);
        sharanya.setCompentencyLevel("Advanced");
        Skills existingSkills = skillsServiceimpl.updateSkills(sharanya.getEmployeeId(), sharanya);

        assertNotNull(existingSkills);
        // assertThat(existingSkills.getCompentencyLevel()).isEqualTo("Advanced");
        assertEquals("Advanced", existingSkills.getCompentencyLevel());

    }

}
