package com.zaga.employee_onboarding.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zaga.employee_onboarding.entity.DayOff;
import com.zaga.employee_onboarding.service.DayOffService;
import com.zaga.employee_onboarding.serviceimpl.DayOffServiceimpl;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// @ExtendWith(MockitoExtension.class)
// @ContextConfiguration(classes = Application.class)
@AutoConfigureMockMvc
public class DayOffControllerTest
{
    @Autowired
    MockMvc mockMvc;

    @MockBean
    DayOffServiceimpl dayOffServiceimpl;

    @Autowired
    ObjectMapper objectmapper;

    public DayOff dayofftest;

    @BeforeEach
    void init()
    {
        dayofftest=new DayOff();
        dayofftest.setEmployeeId("6");
        dayofftest.setEmployeeName("Pavi");
        dayofftest.setAllocatedLeave("10");
        dayofftest.setUsed("8");
        dayofftest.setBalance("2");
    }
    @Test
    void shouldCreateDayOff() throws Exception{
        when(dayOffServiceimpl.createDayOff(any(DayOff.class))).thenReturn(dayofftest);
        this.mockMvc.perform(post("/createDayOff")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectmapper.writeValueAsString(dayofftest)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.employeeId", is(dayofftest.getEmployeeId())))
            .andExpect(jsonPath("$.employeeName", is(dayofftest.getEmployeeName())))
            .andExpect(jsonPath("$.allocatedLeave", is(dayofftest.getAllocatedLeave())))
            .andExpect(jsonPath("$.used", is(dayofftest.getUsed())))
            .andExpect(jsonPath("$.balance", is(dayofftest.getBalance())));
    }

    @Test
    void shouldFetchAllDayOffDetails() throws Exception{
        List<DayOff> dayOffList=new ArrayList<>();
        dayOffList.add(dayofftest);

        when(dayOffServiceimpl.getDayOff()).thenReturn(dayOffList);

        this.mockMvc.perform(get("/getAllDayOff")
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.size()", is(dayOffList.size())));

    }

    @Test
    void shouldFetchDayOffById() throws Exception{
        when(dayOffServiceimpl.getDayOffById(anyString())).thenReturn(dayofftest);

        this.mockMvc.perform(get("/getDayOffById")
            .param("employeeId", "1")
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.allocatedLeave", is(dayofftest.getAllocatedLeave())));

    }

    @Test
    void shouldUpdateDayOff() throws Exception{
        when(dayOffServiceimpl.updateDayOff(anyString(), any(DayOff.class))).thenReturn(dayofftest);
            
        this.mockMvc.perform(put("/updateDayOff")
            .param("employeeId", "1")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectmapper.writeValueAsString(dayofftest)))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.allocatedLeave", is(dayofftest.getAllocatedLeave())))
        .andExpect(jsonPath("$.used", is(dayofftest.getUsed())))
        .andExpect(jsonPath("$.balance", is(dayofftest.getBalance())));

    
    }

    
}
