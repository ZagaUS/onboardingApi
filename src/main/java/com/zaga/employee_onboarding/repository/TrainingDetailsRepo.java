package com.zaga.employee_onboarding.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zaga.employee_onboarding.entity.TrainingDetails;

public interface TrainingDetailsRepo extends MongoRepository<TrainingDetails, String> {
    
}
