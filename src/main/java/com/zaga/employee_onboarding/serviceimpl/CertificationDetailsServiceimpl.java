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
    CertificationDetailsRepo trainingRepo;

    @Override
    public CertificationDetails createTraining(CertificationDetails training) {
        CertificationDetails training2 = trainingRepo.save(training);
        return training2;
    }

    @Override
    public List<CertificationDetails> getAllTraining() {
        List<CertificationDetails> getTraining = trainingRepo.findAll();
        return getTraining;
    }

    @Override
    public CertificationDetails getTrainingById(String employeeId) {
        CertificationDetails getTraining = trainingRepo.findById(employeeId).get();
        return getTraining;
    }

    @Override
    public CertificationDetails updateTraining(String employeeId, CertificationDetails training) {
        CertificationDetails updateTraining = trainingRepo.findById(employeeId).get();
        updateTraining.setCourseName(training.getCourseName());
        updateTraining.setCertificationName(training.getCertificationName());
        updateTraining.setLevel(training.getLevel());
        updateTraining.setValidity(training.getValidity());
        return trainingRepo.save(updateTraining);
    }
}
