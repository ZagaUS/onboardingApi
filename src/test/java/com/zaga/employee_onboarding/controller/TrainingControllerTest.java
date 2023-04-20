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

import java.util.ArrayList;
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
import com.zaga.employee_onboarding.entity.Training;
import com.zaga.employee_onboarding.serviceimpl.TrainingServiceimpl;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class TrainingControllerTest {
    
    @Autowired
    MockMvc mockMvc;

    @MockBean
    TrainingServiceimpl trainingServiceimpl;

    @Autowired
    ObjectMapper objectMapper;

    public Training certificationCourse1;
    public Training certificationCourse2;

    @BeforeEach
    void init() {
        certificationCourse1 = new Training();
        certificationCourse1.setEmployeeId("1");
        certificationCourse1.setEmployeeName("Sharanya");
        certificationCourse1.setCourseName("Linux");
        certificationCourse1.setCertificationName("RHCSA Certification");
        certificationCourse1.setLevel("Advanced");
        certificationCourse1.setValidity("2024-05-25");

        certificationCourse2 = new Training();
        certificationCourse2.setEmployeeId("2");
        certificationCourse2.setEmployeeName("Pavithra");
        certificationCourse2.setCourseName("Java");
        certificationCourse2.setCertificationName("Java Certification");
        certificationCourse2.setLevel("Intermediate");
        certificationCourse2.setValidity("2024-05-25");
    }

    @Test
    void shouldCreateTrainingDetails() throws Exception {
        when(trainingServiceimpl.createTraining(any(Training.class))).thenReturn(certificationCourse1);

        mockMvc.perform(post("/training")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(certificationCourse1)))
        
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.employeeId", is(certificationCourse1.getEmployeeId())))
        .andExpect(jsonPath("$.employeeName", is(certificationCourse1.getEmployeeName())))
        .andExpect(jsonPath("$.courseName", is(certificationCourse1.getCourseName())))
        .andExpect(jsonPath("$.certificationName", is(certificationCourse1.getCertificationName())))
        .andExpect(jsonPath("$.level", is(certificationCourse1.getLevel())))
        .andExpect(jsonPath("$.validity", is(certificationCourse1.getValidity())));
    }

    @Test
    void shouldFetchAllTrainingDetails() throws Exception {
        List<Training> trainingList = new ArrayList<>();
        trainingList.add(certificationCourse1);
        trainingList.add(certificationCourse2);

        when(trainingServiceimpl.getAllTraining()).thenReturn(trainingList);

        this.mockMvc.perform(get("/getAllTraining")
                .contentType(MediaType.APPLICATION_JSON))

        .andExpect(status().isOk())
        .andExpect(jsonPath("$.size()", is(trainingList.size())));

                // .andExpect(status().isOk())
                // .andExpect(jsonPath("$[0].courseName", is("Linux")))
                // .andExpect(jsonPath("$[0].certificationName", is("RHCSA Certification")))
                // .andExpect(jsonPath("$[0].level", is("Advanced")))
                // .andExpect(jsonPath("$[0].validity", is("2024-05-25")))
                // .andExpect(jsonPath("$[1].courseName", is("Java")))
                // .andExpect(jsonPath("$[1].certificationName", is("Java Certification")))
                // .andExpect(jsonPath("$[1].level", is("Intermediate")))
                // .andExpect(jsonPath("$[1].validity", is("2024-05-25")));
    }

    @Test
    void getTrainingDetailsById() throws Exception {
        when(trainingServiceimpl.getTrainingById(anyString())).thenReturn(certificationCourse1);

        this.mockMvc.perform(get("/getTrainingById")
                .param("employeeId", "1")
                .contentType(MediaType.APPLICATION_JSON)) 
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.courseName", is(certificationCourse1.getCourseName())));

    }

    @Test
    void shouldUpdateTrainingDetails() throws Exception {
        when(trainingServiceimpl.updateTraining(anyString(), any(Training.class))).thenReturn(certificationCourse1);

        this.mockMvc.perform(put("/updateTraining")
                .param("employeeId", "1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(certificationCourse1)))
        
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.courseName", is(certificationCourse1.getCourseName())))
        .andExpect(jsonPath("$.certificationName", is(certificationCourse1.getCertificationName())))
        .andExpect(jsonPath("$.level", is(certificationCourse1.getLevel())))
        .andExpect(jsonPath("$.validity", is(certificationCourse1.getValidity())));
    }

}