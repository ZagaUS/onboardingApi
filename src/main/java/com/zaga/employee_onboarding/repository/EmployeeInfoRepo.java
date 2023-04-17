package com.zaga.employee_onboarding.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.stereotype.Repository;
import com.zaga.employee_onboarding.entity.EmployeeInfo;
import com.zaga.employee_onboarding.entity.dto.JobHistoryDTO;
import com.zaga.employee_onboarding.entity.dto.PersonalInfo;

@Repository
public interface EmployeeInfoRepo extends MongoRepository<EmployeeInfo, String> {

   @Query(value = "{ 'employeeId' : ?0 }")
   @Update("{ $set: { 'fileName' : ?1, 'file' : ?2 } }")
   public void updateData(String employeeId, String fileName, byte[] bs);

   @Query(value = "{'employeeId' : ?0}")
   public EmployeeInfo getEmployeeInfo(String employeeId);

   
    @Query(value ="{'employeeId' : ?0}")
    public PersonalInfo getPersonalInfo(String employeeId);

    @Query(value = "{ 'employeeId' : ?0 }")
    @Update("{ $set: { 'employeeId' : ?1} }")
    public void updatePersonalInfo(String employeeId);


}
