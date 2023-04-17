package com.zaga.employee_onboarding.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaga.employee_onboarding.entity.Training;
import com.zaga.employee_onboarding.repository.TrainingRepo;
import com.zaga.employee_onboarding.service.TrainingService;

@Service
public class TrainingServiceimpl implements TrainingService {
    
    @Autowired
    TrainingRepo trainingRepo;

    @Override
    public Training createTraining(Training training) {
        Training training2 = trainingRepo.save(training);
        return training2;
    }

    @Override
    public List<Training> getAllTraining() {
        List<Training> getTraining = trainingRepo.findAll();
        return getTraining;
    }

    @Override
    public Training getTrainingById(String employeeId) {
        Training getTraining = trainingRepo.findById(employeeId).get();
        return getTraining;
    }

    @Override
    public Training updateTraining(String employeeId, Training training) {
        Training updateTraining = trainingRepo.findById(employeeId).get();
        updateTraining.setCourseName(training.getCourseName());
        updateTraining.setCertificationName(training.getCertificationName());
        updateTraining.setLevel(training.getLevel());
        updateTraining.setValidity(training.getValidity());
        return trainingRepo.save(updateTraining);
    }
}
