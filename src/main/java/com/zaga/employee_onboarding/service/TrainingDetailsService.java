package com.zaga.employee_onboarding.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zaga.employee_onboarding.entity.TrainingDetails;

@Service
public interface TrainingDetailsService {

    public TrainingDetails createTrainingDetails(TrainingDetails trainingDetails);

    public List<TrainingDetails> getAllTrainingDetails();

    public TrainingDetails getTrainingDetailsById(String employeeId);

    public TrainingDetails updateTrainingDetails(String employeeId, TrainingDetails trainingDetails);
    
}
