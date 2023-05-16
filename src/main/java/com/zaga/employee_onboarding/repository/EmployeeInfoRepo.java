package com.zaga.employee_onboarding.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.zaga.employee_onboarding.entity.EmployeeInfo;

public interface EmployeeInfoRepo extends MongoRepository<EmployeeInfo, String> {

    @Query(value = "{'projectAssignmentStatus' : false}")
    public List<EmployeeInfo> getInactiveEmployeeInfo();
}
