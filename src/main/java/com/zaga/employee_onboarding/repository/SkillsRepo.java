package com.zaga.employee_onboarding.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zaga.employee_onboarding.entity.Skills;

public interface SkillsRepo extends MongoRepository<Skills, String> {
    
}
