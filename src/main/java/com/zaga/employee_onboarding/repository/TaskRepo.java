package com.zaga.employee_onboarding.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.zaga.employee_onboarding.entity.Task;

@Repository
public interface TaskRepo extends MongoRepository<Task, String> {
    
}
