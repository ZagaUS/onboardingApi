package com.zaga.employee_onboarding.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zaga.employee_onboarding.entity.Training;

public interface TrainingRepo extends MongoRepository<Training, String> {
    
}
