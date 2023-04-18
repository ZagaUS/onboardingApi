package com.zaga.employee_onboarding.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.zaga.employee_onboarding.entity.EmployeeInfo;

public interface EmployeeInfoRepo extends MongoRepository<EmployeeInfo, String> {

}
