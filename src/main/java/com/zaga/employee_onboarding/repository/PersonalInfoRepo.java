package com.zaga.employee_onboarding.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zaga.employee_onboarding.entity.PersonalInfo;

public interface PersonalInfoRepo  extends MongoRepository<PersonalInfo, String>{

} 
