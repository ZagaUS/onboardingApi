package com.zaga.employee_onboarding.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zaga.employee_onboarding.entity.SequenceGenerator;

public interface SequenceGeneratorRepo extends MongoRepository<SequenceGenerator, String> {

    Optional<SequenceGenerator> findById(String sequenceName);

}
