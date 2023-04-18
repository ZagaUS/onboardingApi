package com.zaga.employee_onboarding.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.zaga.employee_onboarding.entity.EducationDetails;

@Repository
public interface EducationDetailsRepo extends MongoRepository<EducationDetails, String> {

    @Query(value = "{'employeeId' : ?0}")
    public EducationDetails getEducationalDetails(String employeeId);

    @Query(value = "{'employeeName' : ?0}")
    public EducationDetails getEducationalDetailsbyName(String employeeName);
}
