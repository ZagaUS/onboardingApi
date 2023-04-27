package com.zaga.employee_onboarding.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zaga.employee_onboarding.entity.CertificationDetails;

@Service
public interface CertificationDetailsService {

    public CertificationDetails createCertificationDetails(CertificationDetails certificationDetails);

    public List<CertificationDetails> getAllCertificationDetails();

    public CertificationDetails getCertificationDetailsById(String employeeId);

    public CertificationDetails updateCertificationDetails(String employeeId, CertificationDetails certificationDetails);
    
}
