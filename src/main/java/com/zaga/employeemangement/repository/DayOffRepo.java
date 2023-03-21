package com.zaga.employeemangement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.zaga.employeemangement.entity.DayOff;

public interface DayOffRepo extends MongoRepository<DayOff, String> {

   @Query(value = "{'employeeId' : ?0}", delete = true)
   public DayOff DeleteByEmpId(String employeeId);

}
