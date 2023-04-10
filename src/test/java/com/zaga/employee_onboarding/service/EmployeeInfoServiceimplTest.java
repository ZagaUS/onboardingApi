package com.zaga.employee_onboarding.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.types.Binary;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import com.zaga.employee_onboarding.entity.EmployeeInfo;
import com.zaga.employee_onboarding.entity.dto.EducationDetailsDTO;
import com.zaga.employee_onboarding.entity.dto.JobHistoryDTO;
import com.zaga.employee_onboarding.repository.EmployeeInfoRepo;
import com.zaga.employee_onboarding.service.EmployeeInfoService;

@SpringBootTest
public class EmployeeInfoServiceimplTest {

    @Autowired
    private EmployeeInfoService employeeInfoService;

    @Autowired
    private EmployeeInfoRepo employeeInfoRepo;

    @Test
    public void testAddDetails() throws IOException {
        List<JobHistoryDTO> jobHistoryDetails = Arrays.asList(
            new JobHistoryDTO("Company A", "Developer", "2020-01-01", "2022-01-01", "String"),
            new JobHistoryDTO("Company B", "Senior Developer", "2018-01-01", "2020-01-01", "String")
        );
    
        List<EducationDetailsDTO> educationDetails = Arrays.asList(
            new EducationDetailsDTO("String", "String", "String", "String", "String"),
            new EducationDetailsDTO("String", "String", "String", "String", "String")
        );
    
        List<String> skillsName = new ArrayList<>();
            skillsName.add("Java");
            skillsName.add("SpringBoot");
    
        List<String> toolsName = new ArrayList<>();
            toolsName.add("VS Code");
            toolsName.add("Postman");
       
        EmployeeInfo employeeInfo = new EmployeeInfo("2", "String", "String", "String", "String", "string", "String", "String", "String", "String", 2, true, "String", "String", "String", "String", "String", "String", "String", "String", "String", "String", jobHistoryDetails, educationDetails, skillsName, toolsName, "String", "String", "BR3_My_Personal_Stress_Plan.pdf", new byte[] { 1, 2, 3 }, "String", "String", "String", "String", "String", "String", "String");

        EmployeeInfo result = employeeInfoService.addDetails(employeeInfo);

        assertNotNull(result.getEmployeeId());
        assertEquals(result.getEmployeeId(), employeeInfo.getEmployeeId());
        assertEquals(result.getEmployeeName(), employeeInfo.getEmployeeName());

        employeeInfoRepo.deleteById(result.getEmployeeId());
    }

    @Test
    public void testUpdateEmpDocuments() throws IOException {
        // create test employee info
        EmployeeInfo employeeInfo = new EmployeeInfo();
        employeeInfo.setEmployeeId("2");
        EmployeeInfo savedEmployeeInfo = employeeInfoRepo.save(employeeInfo);

        // create test file
        byte[] testData = "test data".getBytes();
        MultipartFile file = new MockMultipartFile("BR3_My_Personal_Stress_Plan.pdf", testData);

        // update employee info with test file
        String result = employeeInfoService.updateEmpDocuments(file);
        assertEquals(result, "success");

        // verify updated employee info
        EmployeeInfo updatedEmployeeInfo = employeeInfoRepo.findById(savedEmployeeInfo.getEmployeeId()).get();
        assertEquals(updatedEmployeeInfo.getFileName(), "BR3_My_Personal_Stress_Plan.pdf");
        // assertEquals(new String(updatedEmployeeInfo.getFile().getData()), "test data");

        employeeInfoRepo.deleteById(savedEmployeeInfo.getEmployeeId());
    }
}
