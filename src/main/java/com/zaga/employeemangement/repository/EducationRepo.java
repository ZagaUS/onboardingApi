package com.zaga.employeemangement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.zaga.employeemangement.entity.dto.EducationDTO;

public interface EducationRepo extends MongoRepository<EducationDTO, String> {

   @Query(value = "{'employeeId' : ?0}", delete = true)
   public EducationDTO DeleteByEmpId(String employeeId);

}
