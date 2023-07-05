package com.zaga.employee_onboarding.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaga.employee_onboarding.entity.CertificationDetails;
import com.zaga.employee_onboarding.repository.CertificationDetailsRepo;
import com.zaga.employee_onboarding.service.CertificationDetailsService;

@Service
public class CertificationDetailsServiceimpl implements CertificationDetailsService {
    
    @Autowired
    CertificationDetailsRepo certificationDetailsRepo;

    @Override
    public CertificationDetails createCertificationDetails(CertificationDetails certificationDetails) {
        CertificationDetails details = certificationDetailsRepo.save(certificationDetails);
        System.out.println("Created Certification Details");
        return details;
    }

    @Override
    public List<CertificationDetails> getAllCertificationDetails() {
        List<CertificationDetails> getDetails = certificationDetailsRepo.findAll();
        return getDetails;
    }

    @Override
    public CertificationDetails getCertificationDetailsById(String employeeId) {
        CertificationDetails getDetailsById = certificationDetailsRepo.findById(employeeId).get();
        return getDetailsById;
    }

    @Override
    public CertificationDetails updateCertificationDetails(String employeeId, CertificationDetails certificationDetails) {
        CertificationDetails updateCertificationDetails = certificationDetailsRepo.findById(employeeId).get();
        updateCertificationDetails.setCourseName(certificationDetails.getCourseName());
        updateCertificationDetails.setCertificationName(certificationDetails.getCertificationName());
        updateCertificationDetails.setLevel(certificationDetails.getLevel());
        updateCertificationDetails.setValidity(certificationDetails.getValidity());
        return certificationDetailsRepo.save(updateCertificationDetails);
    }
}
