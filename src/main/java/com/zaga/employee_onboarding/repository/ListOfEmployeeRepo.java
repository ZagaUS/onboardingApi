package com.zaga.employee_onboarding.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zaga.employee_onboarding.entity.ListOfEmployee;

public interface ListOfEmployeeRepo extends MongoRepository<ListOfEmployee, String> {
    
}
