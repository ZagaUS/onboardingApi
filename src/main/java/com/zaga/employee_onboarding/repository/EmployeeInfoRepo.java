package com.zaga.employee_onboarding.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.stereotype.Repository;

import com.zaga.employee_onboarding.entity.EmployeeInfo;

@Repository
public interface EmployeeInfoRepo extends MongoRepository<EmployeeInfo, String> {

   @Query(value = "{ 'employeeId' : ?0 }")
   @Update("{ $set: { 'fileName' : ?1, 'file' : ?2 } }")
   public void updateData(String employeeId, String fileName, byte[] bs);

   @Query(value = "{'employeeId' : ?0}")
   public EmployeeInfo getEmployeeInfo(String employeeId);

}
