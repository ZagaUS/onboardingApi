package com.zaga.employee_onboarding.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.zaga.employee_onboarding.entity.DayOff;

public interface DayOffRepo extends MongoRepository<DayOff, String> {
    
    @Query(value = "{ 'employeeId' : ?0 }")
    public DayOff findByEmployeeId(String employeeId);
}
