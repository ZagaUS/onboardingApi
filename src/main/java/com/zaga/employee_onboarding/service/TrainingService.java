package com.zaga.employee_onboarding.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zaga.employee_onboarding.entity.Training;

@Service
public interface TrainingService {

    public Training createTraining(Training training);

    public List<Training> getAllTraining();

    public Training getTrainingById(String employeeId);

    public Training updateTraining(String employeeId, Training training);
    
}
