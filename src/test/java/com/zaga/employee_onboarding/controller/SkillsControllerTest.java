package com.zaga.employee_onboarding.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zaga.employee_onboarding.entity.Skills;
import com.zaga.employee_onboarding.serviceimpl.SkillsServiceimpl;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class SkillsControllerTest {
    
    @Autowired
    MockMvc mockMvc;

    @MockBean
    SkillsServiceimpl skillsServiceimpl;

    @Autowired
    ObjectMapper objectMapper;

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
    void shouldCreateSkills() throws Exception {
        when(skillsServiceimpl.createSkills(any(Skills.class))).thenReturn(sharanya);
        
        this.mockMvc.perform(post("/skills")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(sharanya)))
                
        .andExpect(status().isOk());
    }
    
}
