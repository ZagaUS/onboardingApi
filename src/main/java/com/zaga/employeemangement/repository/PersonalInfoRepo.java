package com.zaga.employeemangement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.zaga.employeemangement.entity.PersonalInfo;

public interface PersonalInfoRepo extends MongoRepository<PersonalInfo, String> {

   @Query(value = "{'employeeId' : ?0}", delete = true)
   public PersonalInfo DeleteByEmpId(String employeeId);

}
