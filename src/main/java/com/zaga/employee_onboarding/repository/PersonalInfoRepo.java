package com.zaga.employee_onboarding.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.zaga.employee_onboarding.entity.PersonalInfo;

public interface PersonalInfoRepo  extends MongoRepository<PersonalInfo, String>{

    @Query(value ="{'employeeId' : ?0}")
    public PersonalInfo getPersonalnfo(String employeeId);
    
} 
    
