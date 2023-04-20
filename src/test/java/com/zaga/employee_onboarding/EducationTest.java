package com.zaga.employee_onboarding;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.zaga.employee_onboarding.entity.EducationDetails;
import com.zaga.employee_onboarding.entity.dto.EducationDetailsDTO;
import com.zaga.employee_onboarding.repository.EducationDetailsRepo;

@DataMongoTest
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EducationTest {
    @Autowired
    EducationDetailsRepo repo;

    @Test
    void addJobHistory() {

        List<EducationDetailsDTO> list = new ArrayList<>();
        EducationDetailsDTO dto = EducationDetailsDTO.builder().collegeName("abc college").degree("B.E")
        .graduate("Bachlore degree").specialization("Mech").year("2023").build();
        list.add(dto);
        EducationDetails payload = EducationDetails.builder()
                .employeeId("1").employeeName("bala").educationDetails(list).build();

        repo.save(payload);
       
        EducationDetails result = repo.getEducationalDetails(payload.getEmployeeId());
        assertEquals(payload, result);
    }





}
