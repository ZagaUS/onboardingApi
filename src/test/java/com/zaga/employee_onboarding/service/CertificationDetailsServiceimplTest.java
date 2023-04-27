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
    CertificationDetailsRepo certificationDetailsRepo;

    @InjectMocks
    CertificationDetailsServiceimpl certificationDetailsServiceimpl;

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
        when(certificationDetailsRepo.save(any(CertificationDetails.class))).thenReturn(certificationCourse1);

        CertificationDetails certificationDetails = certificationDetailsServiceimpl.createCertificationDetails(certificationCourse1);

        assertNotNull(certificationDetails);
        assertThat(certificationDetails.getEmployeeId()).isEqualTo("1");
    }

    @Test
    void getAllTraining() {
        List<CertificationDetails> certificationDetails = new ArrayList<>();
        certificationDetails.add(certificationCourse1);
        certificationDetails.add(certificationCourse2);

        when(certificationDetailsRepo.findAll()).thenReturn(certificationDetails);
        
        List<CertificationDetails> certificationDetailsList = certificationDetailsServiceimpl.getAllCertificationDetails();

        assertEquals(2, certificationDetailsList.size());
        assertNotNull(certificationDetailsList);
    }

    @Test
    void getTrainingById() {
        when(certificationDetailsRepo.findById(anyString())).thenReturn(Optional.of(certificationCourse1));

        CertificationDetails certificationDetails = certificationDetailsServiceimpl.getCertificationDetailsById(certificationCourse1.getEmployeeId());

        assertNotNull(certificationDetails);
        assertThat(certificationDetails.getEmployeeId()).isEqualTo("1");
    }

    @Test
    void updateTraining() {
        when(certificationDetailsRepo.findById(anyString())).thenReturn(Optional.of(certificationCourse1));

        when(certificationDetailsRepo.save(any(CertificationDetails.class))).thenReturn(certificationCourse1);
        certificationCourse1.setValidity("2024-01-01");
        CertificationDetails certificationDetails = certificationDetailsServiceimpl.updateCertificationDetails(certificationCourse1.getEmployeeId(), certificationCourse1);

        assertNotNull(certificationDetails);
        assertEquals("2024-01-01", certificationDetails.getValidity());
    }
    
}
