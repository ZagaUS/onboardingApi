package com.zaga.employee_onboarding.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaga.employee_onboarding.entity.TrainingDetails;
import com.zaga.employee_onboarding.repository.TrainingDetailsRepo;
import com.zaga.employee_onboarding.service.TrainingDetailsService;

@Service
public class TrainingDetailsServiceimpl implements TrainingDetailsService {
    @Autowired
    TrainingDetailsRepo trainingDetailsRepo;

    @Override
    public TrainingDetails createTrainingDetails(TrainingDetails trainingDetails) {
        TrainingDetails details = trainingDetailsRepo.save(trainingDetails);
        return details;
    }

    @Override
    public List<TrainingDetails> getAllTrainingDetails() {
        List<TrainingDetails> getDetails = trainingDetailsRepo.findAll();
        return getDetails;
    }

    @Override
    public TrainingDetails getTrainingDetailsById(String employeeId) {
        TrainingDetails getDetailsById = trainingDetailsRepo.findById(employeeId).get();
        return getDetailsById;
    }

    @Override
    public TrainingDetails updateTrainingDetails(String employeeId, TrainingDetails trainingDetails) {
        TrainingDetails updateTrainingDetails = trainingDetailsRepo.findById(employeeId).get();
        updateTrainingDetails.setTrainingName(trainingDetails.getTrainingName());
        updateTrainingDetails.setTrainerName(trainingDetails.getTrainerName());
        updateTrainingDetails.setTraineeName(trainingDetails.getTraineeName());
        updateTrainingDetails.setTrainingStartDate(trainingDetails.getTrainingStartDate());
        updateTrainingDetails.setTrainingEndDate(trainingDetails.getTrainingEndDate());
        return trainingDetailsRepo.save(updateTrainingDetails);
    }

}
