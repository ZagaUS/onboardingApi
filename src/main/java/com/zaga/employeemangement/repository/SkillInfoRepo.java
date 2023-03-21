package com.zaga.employeemangement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.zaga.employeemangement.entity.SkillInfo;

public interface SkillInfoRepo extends MongoRepository<SkillInfo, String> {

   @Query(value = "{'employeeId' : ?0}", delete = true)
   public SkillInfo DeleteByEmpId(String employeeId);

}
