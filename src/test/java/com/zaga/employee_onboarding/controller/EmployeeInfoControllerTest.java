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
import com.zaga.employee_onboarding.entity.EmployeeInfo;
import com.zaga.employee_onboarding.serviceimpl.EmployeeInfoServiceimpl;

// @WebMvcTest
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// @ExtendWith(MockitoExtension.class)
// @ContextConfiguration(classes = Application.class)
@AutoConfigureMockMvc
public class EmployeeInfoControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    EmployeeInfoServiceimpl employeeInfoServiceimpl;

    @Autowired
    ObjectMapper objectMapper;

    public EmployeeInfo sharanya;
    public EmployeeInfo pavithra;

    @BeforeEach
    void init() {
        sharanya = new EmployeeInfo();
        sharanya.setEmployeeId("1");
        sharanya.setEmployeeName("Sharanya");
        sharanya.setEmployeeRole("Employee");
        sharanya.setJobTitle("Software Engineer");
        sharanya.setDateOfJoining("2022-11-01");
        sharanya.setEmployeeEmail("sharanya@gmail.com");
        sharanya.setPassword("1234");
        sharanya.setDepartment("IT");
        sharanya.setReportingManager("Giri");
        sharanya.setEmployeeStatus("Active");
        sharanya.setOverallExperience(1);
        sharanya.setProjectAssignmentStatus(true);

        pavithra = new EmployeeInfo();
        pavithra.setEmployeeId("2");
        pavithra.setEmployeeName("Pavithra");
        pavithra.setEmployeeRole("Employee");
        pavithra.setJobTitle("Software Engineer");
        pavithra.setDateOfJoining("2022-11-01");
        pavithra.setEmployeeEmail("pavithra@gmail.com");
        pavithra.setPassword("1234");
        pavithra.setDepartment("IT");
        pavithra.setReportingManager("Giri");
        pavithra.setEmployeeStatus("Active");
        pavithra.setOverallExperience(1);
        pavithra.setProjectAssignmentStatus(true);

    }

    @Test
    void shouldCreateNewEmployeeInfo() throws Exception {
        when(employeeInfoServiceimpl.addDetails(any(EmployeeInfo.class))).thenReturn(sharanya);

        this.mockMvc.perform(post("/createEmployeeInfo")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(sharanya)))
        // .andExpect(status().isCreated())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.employeeId", is(sharanya.getEmployeeId())))
        .andExpect(jsonPath("$.employeeName", is(sharanya.getEmployeeName())))
        .andExpect(jsonPath("$.employeeRole", is(sharanya.getEmployeeRole())))
        .andExpect(jsonPath("$.jobTitle", is(sharanya.getJobTitle())))
        .andExpect(jsonPath("$.dateOfJoining", is(sharanya.getDateOfJoining())))
        .andExpect(jsonPath("$.employeeEmail", is(sharanya.getEmployeeEmail())))
        .andExpect(jsonPath("$.password", is(sharanya.getPassword())))
        .andExpect(jsonPath("$.department", is(sharanya.getDepartment())))
        .andExpect(jsonPath("$.reportingManager", is(sharanya.getReportingManager())))
        .andExpect(jsonPath("$.employeeStatus", is(sharanya.getEmployeeStatus())))
        .andExpect(jsonPath("$.overallExperience", is(sharanya.getOverallExperience())))
        .andExpect(jsonPath("$.projectAssignmentStatus", is(sharanya.getProjectAssignmentStatus())));

    }

    @Test
    void shouldFetchAllEmployeeInfo() throws Exception {
        List<EmployeeInfo> employeeInfoList = new ArrayList<>();
        employeeInfoList.add(sharanya);
        employeeInfoList.add(pavithra);

        when(employeeInfoServiceimpl.getAllDetails()).thenReturn(employeeInfoList);

        this.mockMvc.perform(get("/getAllEmployeeInfo")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.size()", is(employeeInfoList.size())));
        
    }

    // @Test
    // void shouldFetchEmployeeInfoById() throws Exception {
    //     when(employeeInfoServiceimpl.getDetailsById(anyString())).thenReturn(sharanya);

    //     this.mockMvc.perform(get("/getEmployeeInfo", 1)
    //             .contentType(MediaType.APPLICATION_JSON))
    //         // .andExpect(status().isOk())
    //     .andExpect(jsonPath("$.employeeEmail", is(sharanya.getEmployeeEmail())));
    //     // .andExpect(jsonPath("$.employeeEmail", is(sharanya.getEmployeeEmail())))
    // }

    @Test
    void shouldFetchEmployeeInfoById() throws Exception {
        when(employeeInfoServiceimpl.getDetailsById(anyString())).thenReturn(sharanya);

        this.mockMvc.perform(get("/getEmployeeInfo")
                .param("employeeId", "1")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.employeeEmail", is(sharanya.getEmployeeEmail())));
    }

    @Test
    void shouldUpdateEmployeeInfo() throws Exception {
        when(employeeInfoServiceimpl.updateDetails(anyString(), any(EmployeeInfo.class))).thenReturn(sharanya);

        this.mockMvc.perform(put("/updateEmployeeInfo/{employeeId}", "1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(sharanya)))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.employeeRole", is(sharanya.getEmployeeRole())))
        .andExpect(jsonPath("$.jobTitle", is(sharanya.getJobTitle())))
        .andExpect(jsonPath("$.dateOfJoining", is(sharanya.getDateOfJoining())))
        .andExpect(jsonPath("$.employeeEmail", is(sharanya.getEmployeeEmail())))
        .andExpect(jsonPath("$.password", is(sharanya.getPassword())))
        .andExpect(jsonPath("$.department", is(sharanya.getDepartment())))
        .andExpect(jsonPath("$.reportingManager", is(sharanya.getReportingManager())))
        .andExpect(jsonPath("$.employeeStatus", is(sharanya.getEmployeeStatus())))
        .andExpect(jsonPath("$.overallExperience", is(sharanya.getOverallExperience())))
        .andExpect(jsonPath("$.projectAssignmentStatus", is(sharanya.getProjectAssignmentStatus())));
    }
}
