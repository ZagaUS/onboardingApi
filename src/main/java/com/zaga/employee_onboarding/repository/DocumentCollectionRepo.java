package com.zaga.employee_onboarding.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zaga.employee_onboarding.entity.DocumentCollection;

public interface DocumentCollectionRepo extends MongoRepository<DocumentCollection, String>{
    
}
