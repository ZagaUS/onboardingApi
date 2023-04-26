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

import org.springframework.http.MediaType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zaga.employee_onboarding.entity.PersonalInfo;
import com.zaga.employee_onboarding.serviceimpl.PersonalInfoServiceImpl;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PersonalInfoControllerTest {
    
    @Autowired
    MockMvc mockMvc;

    @MockBean
    PersonalInfoServiceImpl personalInfoServiceimpl;

    @Autowired
    ObjectMapper objectMapper;

    public PersonalInfo anushiya;
    public PersonalInfo pavithra;

    @BeforeEach
    void init() {
        anushiya = new PersonalInfo();
        anushiya.setEmployeeId("1");
        anushiya.setEmployeeName("Anushiya");
        anushiya.setGender("female");
        anushiya.setNationality("Indian");
        anushiya.setMaritalStatus("single");
        // anushiya.setLanguage(["English","Tamil","Telugu"]);
        anushiya.setDateOfBirth("1999-05-25");
        anushiya.setBloodGroup("A1B +ve");
        anushiya.setPersonalEmail("anushiyadhamu@gmail.com");
        anushiya.setPersonalPhone("9500934741");
        anushiya.setEmergencyPhone("9500934741");
        anushiya.setAddress("3/31,Middle Street,Idaiseval,Kovilpatti");

        pavithra = new PersonalInfo();
        pavithra.setEmployeeId("2");
        pavithra.setEmployeeName("Pavithra");
        pavithra.setGender("female");
        pavithra.setNationality("Indian");
        pavithra.setMaritalStatus("single");
        // pavithra.setLanguage(["English","Tamil"]);
        pavithra.setDateOfBirth("1995-05-20");
        pavithra.setBloodGroup("o +");
        pavithra.setPersonalEmail("pavipavi491@gmail.com");
        pavithra.setPersonalPhone("9944822686");
        pavithra.setEmergencyPhone("9944822686");
        pavithra.setAddress("No-8-Sankaralingapuram, 1st-East Street, Kovilpatti");

    }

    @Test
    void shouldCreatePersonalInfo() throws Exception {
        when(personalInfoServiceimpl.createPersonalInfo(any(PersonalInfo.class))).thenReturn(anushiya);

        this.mockMvc.perform(post("/addPersonalInfo")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(anushiya)))

            .andExpect(status().isOk())
            .andExpect(jsonPath("$.employeeId", is(anushiya.getEmployeeId())))
            .andExpect(jsonPath("$.employeeName", is(anushiya.getEmployeeName())))
            .andExpect(jsonPath("$.gender", is(anushiya.getGender())))
            .andExpect(jsonPath("$.nationality", is(anushiya.getNationality())))
            .andExpect(jsonPath("$.maritalStatus", is(anushiya.getMaritalStatus())))
            // .andExpect(jsonPath("$.setLanguage", is(anushiya.getLanguage())))
            .andExpect(jsonPath("$.dateOfBirth", is(anushiya.getDateOfBirth())))
            .andExpect(jsonPath("$.bloodGroup", is(anushiya.getBloodGroup())))
            .andExpect(jsonPath("$.personalEmail", is(anushiya.getPersonalEmail())))
            .andExpect(jsonPath("$.personalPhone", is(anushiya.getPersonalPhone())))
            .andExpect(jsonPath("$.emergencyPhone", is(anushiya.getEmergencyPhone())))
            .andExpect(jsonPath("$.address", is(anushiya.getAddress())));

    }

    // @Test
    // void shouldFetchAllPersonalInfo() throws Exception {
    //     List<PersonalInfo> personalInfoList = new ArrayList<>();
    //     personalInfoList.add(anushiya);
    //     personalInfoList.add(pavithra);

    //     when(personalInfoServiceimpl.getPersonalInfo()).thenReturn(personalInfoList);

    //     this.mockMvc.perform(get("/getPersonalInfo")
    //             .contentType(MediaType.APPLICATION_JSON))

    //     .andExpect(status().isOk())
    //     .andExpect(jsonPath("$.size()", is(personalInfoList.size())));

    // }

    @Test
    void getPersonalInfoById() throws Exception {
        when(personalInfoServiceimpl.getPersonalInfoById(anyString())).thenReturn(anushiya);

        this.mockMvc.perform(get("/getPersonalInfoById")
                .param("employeeId", "1")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.personalEmail", is(anushiya.getPersonalEmail())));
        
    }

    @Test
    void shouldUpdateEmployeeInfo() throws Exception {
        when(personalInfoServiceimpl.updatePersonalInfo(anyString(), any(PersonalInfo.class))).thenReturn(anushiya);

        this.mockMvc.perform(put("/updatePersonalInfo", "1")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(anushiya)))

        .andExpect(status().isOk())
        .andExpect(jsonPath("$.gender", is(anushiya.getGender())))
        .andExpect(jsonPath("$.nationality", is(anushiya.getNationality())))
        .andExpect(jsonPath("$.maritalStatus", is(anushiya.getMaritalStatus())))
        // .andExpect(jsonPath("$.language", is(anushiya.getLanguage())))
        .andExpect(jsonPath("$.dateOfBirth", is(anushiya.getDateOfBirth())))
        .andExpect(jsonPath("$.bloodGroup", is(anushiya.getBloodGroup())))
        .andExpect(jsonPath("$.personalEmail", is(anushiya.getPersonalEmail())))
        .andExpect(jsonPath("$.personalPhone", is(anushiya.getPersonalPhone())))
        .andExpect(jsonPath("$.emergencyPhone", is(anushiya.getEmergencyPhone())))
        .andExpect(jsonPath("$.address", is(anushiya.getAddress())));
    }

}
