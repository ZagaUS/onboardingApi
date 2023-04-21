package com.zaga.employee_onboarding;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.zaga.employee_onboarding.entity.Training;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TrainingApiTest {

    private Training responsebody;

    @LocalServerPort
    int port;

    @Test
    @Order(1)
    public void testCreateTraining() throws Exception {
        Training training = Training.builder().employeeId("1").employeeName("Sharanya")
                .courseName("Linux").certificationName("RHCSA Certification").level("Intermediate").validity("2024-05-25").build();
        
        // list.add(training);
        responsebody = RestAssured.given()
                    .baseUri("http://localhost")
                    .port(port).contentType(ContentType.JSON).accept(ContentType.JSON).body(training).when()
                .post("/training")
                .then()
                .statusCode(200).extract().as(Training.class);

        System.out.println(responsebody);
    }

    @Test
    @Order(2)
    public void getTrainingByIdTest() {
        RestAssured.given().baseUri("http://localhost")
                .port(port)
                .contentType(ContentType.JSON)
                .queryParam("employeeId", responsebody.employeeId)
                .when()
                .get("/getTrainingById")
                .then()
                .statusCode(200);
    }

    @Test
    @Order(3)
    public void updateTrainingTest() throws Exception {
        Training updateTraining = Training.builder().employeeId("1").employeeName("Sharanya")
                .validity("2024-01-01").build();
        RestAssured.given().baseUri("http://localhost")
                .port(port)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(updateTraining)
                .when()
                .put("/updateTraining")
                .then();
                // .statusCode(200);
    }
}
