package com.zaga.employeemangement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.zaga.employeemangement.entity.dto.JobHistoryDTO;

public interface JobHistoryRepo extends MongoRepository<JobHistoryDTO, String> {

   @Query(value = "{'employeeId' : ?0}", delete = true)
   public JobHistoryDTO DeleteByEmpId(String employeeId);

}
