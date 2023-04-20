package com.zaga.employee_onboarding.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.zaga.employee_onboarding.entity.DayOff;
import com.zaga.employee_onboarding.repository.DayOffRepo;
import com.zaga.employee_onboarding.serviceimpl.DayOffServiceimpl;



@ExtendWith(MockitoExtension.class)
public class DayOffServiceImplTest {
    @Mock
    DayOffRepo dayOffRepo;

    @InjectMocks
    DayOffServiceimpl dayOffServiceimpl;
    
    public DayOff dayofftest;

    @BeforeEach
    void init()
    {
        dayofftest=new DayOff();
        dayofftest.setEmployeeId("1");
        dayofftest.setEmployeeName("Pavi");
        dayofftest.setAllocatedLeave("10");
        dayofftest.setUsed("8");
        dayofftest.setBalance("2");
    }

    @Test
    void createDayOff() throws IOException{
        when(dayOffRepo.save(any(DayOff.class))).thenReturn(dayofftest);
        
        DayOff dayOff=dayOffServiceimpl.createDayOff(dayofftest);
        
        assertNotNull(dayOff);
        assertThat(dayOff.getEmployeeId()).isEqualTo("1");

    }

    @Test
    void getAllDayOff(){
        List<DayOff> dayoff=new ArrayList<>();
        dayoff.add(dayofftest);
        
        when(dayOffRepo.findAll()).thenReturn(dayoff);

        List<DayOff> dayOffList= dayOffServiceimpl.getDayOff();

        assertEquals(1,dayOffList.size());
        assertNotNull(dayOffList);

    }

    @Test
    void getDayOffById(){
        when(dayOffRepo.findById(anyString())).thenReturn(Optional.of(dayofftest));

        DayOff dayOff = dayOffServiceimpl.getDayOffById(dayofftest.getEmployeeId());

        assertNotNull(dayOff);
        assertThat(dayOff.getEmployeeId()).isEqualTo("1");
    }

    @Test
    void updateDayOff(){
        when(dayOffRepo.findById(anyString())).thenReturn(Optional.of(dayofftest));
        
        when(dayOffRepo.save(any(DayOff.class))).thenReturn(dayofftest);
        dayofftest.setAllocatedLeave("15");
        DayOff existingDayOff = dayOffServiceimpl.updateDayOff(dayofftest.getEmployeeId(),dayofftest);

        assertNotNull(existingDayOff);
        assertEquals("15",dayofftest.getAllocatedLeave());
    }

    }
    
