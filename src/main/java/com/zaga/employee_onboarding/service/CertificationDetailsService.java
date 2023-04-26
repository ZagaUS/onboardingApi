package com.zaga.employee_onboarding.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zaga.employee_onboarding.entity.CertificationDetails;

@Service
public interface CertificationDetailsService {

    public CertificationDetails createTraining(CertificationDetails training);

    public List<CertificationDetails> getAllTraining();

    public CertificationDetails getTrainingById(String employeeId);

    public CertificationDetails updateTraining(String employeeId, CertificationDetails training);
    
}
