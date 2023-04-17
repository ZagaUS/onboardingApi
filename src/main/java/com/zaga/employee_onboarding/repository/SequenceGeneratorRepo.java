package com.zaga.employee_onboarding.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.stereotype.Repository;

import com.zaga.employee_onboarding.entity.SequenceGenerator;
@Repository
public interface SequenceGeneratorRepo extends MongoRepository<SequenceGenerator, String> {
    
    @Query(value = "{'seqName' = ?0 }")
    public SequenceGenerator getSequence(String seqName);

    @Query(value = "{ 'seqName' : ?0 }")
    @Update(value = "{ '$set' : ?1 }")
    public void updatePersonalInfoByEmployeeId(String seqName, SequenceGenerator sequence);

}
