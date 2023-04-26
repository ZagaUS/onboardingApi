package com.zaga.employee_onboarding;

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
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.zaga.employee_onboarding.entity.JobHistory;
import com.zaga.employee_onboarding.entity.dto.JobHistoryDTO;

import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodProcess;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.MongodConfig;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// @SpringBootTest(classes = { EmbeddedMongoConfiguration.class })
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ActiveProfiles("test")
// @Import(EmbeddedMongoConfiguration.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class JobHistoryApiTest {

    // @Autowired
    // MongodConfig mongodConfig;

    private JobHistory responsebody;

    @LocalServerPort
    int port;

    // private MongodProcess mongoProcess;
    // private MongodExecutable mongoExecutable;

    // @BeforeAll
    // public void setup() throws IOException {

    // MongodStarter starter = MongodStarter.getDefaultInstance();

    // mongoExecutable = starter.prepare(mongodConfig);

    // mongoProcess = mongoExecutable.start();

    // }

    // @AfterAll
    // public void cleanup() {
    // mongoProcess.stop();
    // mongoExecutable.stop();
    // }

    @Test
    @Order(1)
    public void testcreate() throws Exception {

        List<JobHistoryDTO> list = new ArrayList<>();
        JobHistoryDTO dto = JobHistoryDTO.builder().companyName("Aaludra Technologies").startDate("2021-09-06")
                .endDate("2022-10-1").field("IT").experience("1").build();
        list.add(dto);
        JobHistory payload = JobHistory.builder()
                .employeeId("").employeeName("Ajay").jobHistoryDetails(list).build();

        responsebody = RestAssured.given()
                .baseUri("http://localhost")
                .port(port).contentType(ContentType.JSON).accept(ContentType.JSON).body(payload).when()
                .post("/jobHistory/create")
                .then()
                .statusCode(200).extract().as(JobHistory.class);

        System.out.println(responsebody);

    }

    @Test
    @Order(2)
    void getJobHistoryByIdTest() {
        RestAssured.given().baseUri("http://localhost")
                .port(port)
                .contentType(ContentType.JSON)
                .queryParam("employeeId", responsebody.employeeId)
                .when()
                .get("/getJobHistoryById")
                .then()
                .statusCode(200);
    }
}
