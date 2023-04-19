package com.zaga.employee_onboarding;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mongodb.client.MongoDatabase;
import com.zaga.employee_onboarding.entity.JobHistory;
import com.zaga.employee_onboarding.entity.dto.JobHistoryDTO;
import com.zaga.employee_onboarding.repository.JobHistoryRepo;

import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodProcess;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.MongoCmdOptions;
import de.flapdoodle.embed.mongo.config.MongodConfig;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.IFeatureAwareVersion;
import de.flapdoodle.embed.mongo.distribution.Version;
import io.restassured.http.ContentType;

// @SpringBootTest(classes = { EmbeddedMongoConfiguration.class })
@DataMongoTest
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class JobHistoryTest {
    @Autowired
    JobHistoryRepo repo;

    @Test
    void addJobHistory() {

        List<JobHistoryDTO> list = new ArrayList<>();
        JobHistoryDTO dto = JobHistoryDTO.builder().companyName("Aaludra Technologies").startDate("2021-09-06")
                .endDate("2022-10-1").field("IT").experience("1").build();
        list.add(dto);
        JobHistory payload = JobHistory.builder()
                .employeeId("1").employeeName("Ajay").jobHistoryDetails(list).build();

        repo.save(payload);

        JobHistory result = repo.getJobHistoryDetails(payload.getEmployeeId());
        assertEquals(payload, result);
    }
}
