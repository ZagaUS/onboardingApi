package com.zaga.employee_onboarding.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zaga.employee_onboarding.entity.CertificationDetails;

public interface CertificationDetailsRepo extends MongoRepository<CertificationDetails, String> {
    
}
