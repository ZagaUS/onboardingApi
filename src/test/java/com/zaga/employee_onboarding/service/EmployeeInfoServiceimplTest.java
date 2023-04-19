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

import com.zaga.employee_onboarding.entity.EmployeeInfo;
import com.zaga.employee_onboarding.entity.ListOfEmployeesDTO;
import com.zaga.employee_onboarding.repository.EmployeeInfoRepo;
import com.zaga.employee_onboarding.serviceimpl.EmployeeInfoServiceimpl;

@ExtendWith(MockitoExtension.class)
public class EmployeeInfoServiceimplTest {

    @Mock
    EmployeeInfoRepo employeeInfoRepo;

    @InjectMocks
    EmployeeInfoServiceimpl employeeInfoServiceimpl;

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
    void addDetails() throws IOException {
        when(employeeInfoRepo.save(any(EmployeeInfo.class))).thenReturn(sharanya);

        EmployeeInfo employeeInfo = employeeInfoServiceimpl.addDetails(sharanya);

        assertNotNull(employeeInfo);
        assertThat(employeeInfo.getEmployeeId()).isEqualTo("1");
    }

    @Test
    void getAllDetails() {
        List<EmployeeInfo> employeeInfo = new ArrayList<>();
        employeeInfo.add(sharanya);
        employeeInfo.add(pavithra);

        when(employeeInfoRepo.findAll()).thenReturn(employeeInfo);

        List<EmployeeInfo> employeeInfoList = employeeInfoServiceimpl.getAllDetails();

        assertEquals(2, employeeInfoList.size());
        assertNotNull(employeeInfoList);
    }

    @Test
    void getListOfEmployees() {
        List<EmployeeInfo> employeeInfo = new ArrayList<>();
        employeeInfo.add(sharanya);
        employeeInfo.add(pavithra);

        when(employeeInfoRepo.findAll()).thenReturn(employeeInfo);

        List<ListOfEmployeesDTO> employeeInfoList = employeeInfoServiceimpl.getListOfEmployees();

        assertEquals(2, employeeInfoList.size());
        assertNotNull(employeeInfoList);
    }

    @Test
    void getDetailsById() {
        when(employeeInfoRepo.findById(anyString())).thenReturn(Optional.of(sharanya));

        EmployeeInfo employeeInfo = employeeInfoServiceimpl.getDetailsById(sharanya.getEmployeeId());

        assertNotNull(employeeInfo);
        assertThat(employeeInfo.getEmployeeId()).isEqualTo("1");
    }

    @Test
    void updateDetails() {
        when(employeeInfoRepo.findById(anyString())).thenReturn(Optional.of(sharanya));

        when(employeeInfoRepo.save(any(EmployeeInfo.class))).thenReturn(sharanya);
        sharanya.setPassword("12345");
        EmployeeInfo existingInfo = employeeInfoServiceimpl.updateDetails(sharanya.getEmployeeId(), sharanya);

        assertNotNull(existingInfo);
        assertEquals("12345", sharanya.getPassword());
    }

}
