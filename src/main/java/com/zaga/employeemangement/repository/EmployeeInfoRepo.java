package com.zaga.employeemangement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.zaga.employeemangement.entity.EmployeeInfo;

public interface EmployeeInfoRepo extends MongoRepository<EmployeeInfo, String> {

   @Query(value = "{'employeeId' : ?0}", delete = true)
   public EmployeeInfo DeleteByEmpId(String employeeId);

}
