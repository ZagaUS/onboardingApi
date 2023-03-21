package com.zaga.employeemangement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.zaga.employeemangement.entity.dto.TrainingDTO;

public interface TrainingRepo extends MongoRepository<TrainingDTO, String> {

   @Query(value = "{'employeeId' : ?0}", delete = true)
   public TrainingDTO DeleteByEmpId(String employeeId);

}
