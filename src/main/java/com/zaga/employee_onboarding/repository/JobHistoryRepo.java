package com.zaga.employee_onboarding.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.zaga.employee_onboarding.entity.JobHistory;

@Repository
public interface JobHistoryRepo extends MongoRepository<JobHistory, String> {

    @Query(value = "{'employeeId' : ?0}")
    public JobHistory getJobHistoryDetails(String employeeId);

    @Query(value = "{'employeeName' : ?0}")
    public JobHistory getJobHistorybyName(String employeeName);

    @Query(value = "{'employeeId' : ?0}", delete = true)
    public void deleteJobHistoryDetails(String employeeId);

}
