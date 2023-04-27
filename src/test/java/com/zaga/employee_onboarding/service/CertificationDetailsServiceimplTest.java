package com.zaga.employee_onboarding.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.zaga.employee_onboarding.entity.CertificationDetails;
import com.zaga.employee_onboarding.repository.CertificationDetailsRepo;
import com.zaga.employee_onboarding.serviceimpl.CertificationDetailsServiceimpl;

@ExtendWith(MockitoExtension.class)
public class CertificationDetailsServiceimplTest {

    @Mock
    CertificationDetailsRepo trainingRepo;

    @InjectMocks
    CertificationDetailsServiceimpl trainingServiceimpl;

    public CertificationDetails certificationCourse1;
    public CertificationDetails certificationCourse2;

    @BeforeEach
    void init() {
        certificationCourse1 = new CertificationDetails();
        certificationCourse1.setEmployeeId("1");
        certificationCourse1.setEmployeeName("Sharanya");
        certificationCourse1.setCourseName("Linux");
        certificationCourse1.setCertificationName("RHCSA Certification");
        certificationCourse1.setLevel("Advanced");
        certificationCourse1.setValidity("2024-05-25");

        certificationCourse2 = new CertificationDetails();
        certificationCourse2.setEmployeeId("2");
        certificationCourse2.setEmployeeName("Pavithra");
        certificationCourse2.setCourseName("Java");
        certificationCourse2.setCertificationName("Java Certification");
        certificationCourse2.setLevel("Intermediate");
        certificationCourse2.setValidity("2024-05-25");
    }

    @Test
    void createTraining() {
        when(trainingRepo.save(any(CertificationDetails.class))).thenReturn(certificationCourse1);

        CertificationDetails training = trainingServiceimpl.createTraining(certificationCourse1);

        assertNotNull(training);
        assertThat(training.getEmployeeId()).isEqualTo("1");
    }

    @Test
    void getAllTraining() {
        List<CertificationDetails> training = new ArrayList<>();
        training.add(certificationCourse1);
        training.add(certificationCourse2);

        when(trainingRepo.findAll()).thenReturn(training);
        
        List<CertificationDetails> trainingList = trainingServiceimpl.getAllTraining();

        assertEquals(2, trainingList.size());
        assertNotNull(trainingList);
    }

    @Test
    void getTrainingById() {
        when(trainingRepo.findById(anyString())).thenReturn(Optional.of(certificationCourse1));

        CertificationDetails training = trainingServiceimpl.getTrainingById(certificationCourse1.getEmployeeId());

        assertNotNull(training);
        assertThat(training.getEmployeeId()).isEqualTo("1");
    }

    @Test
    void updateTraining() {
        when(trainingRepo.findById(anyString())).thenReturn(Optional.of(certificationCourse1));

        when(trainingRepo.save(any(CertificationDetails.class))).thenReturn(certificationCourse1);
        certificationCourse1.setValidity("2024-01-01");
        CertificationDetails training = trainingServiceimpl.updateTraining(certificationCourse1.getEmployeeId(), certificationCourse1);

        assertNotNull(training);
        assertEquals("2024-01-01", training.getValidity());
    }
    
}
