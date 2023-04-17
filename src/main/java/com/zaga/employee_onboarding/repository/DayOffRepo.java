package com.zaga.employee_onboarding.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zaga.employee_onboarding.entity.DayOff;

public interface DayOffRepo extends MongoRepository<DayOff, String> {
    
}
