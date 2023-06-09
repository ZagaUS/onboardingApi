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

import com.zaga.employee_onboarding.entity.CertificationDetails;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CertificationDetailsApiTest {

    private CertificationDetails responsebody;

    @LocalServerPort
    int port;

    @Test
    @Order(1)
    public void testCreateTraining() throws Exception {
        CertificationDetails training = CertificationDetails.builder().employeeId("1").employeeName("Sharanya")
                .courseName("Linux").certificationName("RHCSA Certification").level("Intermediate").validity("2024-05-25").build();
        
        // list.add(training);
        responsebody = RestAssured.given()
                    .baseUri("http://localhost")
                    .port(port).contentType(ContentType.JSON).accept(ContentType.JSON).body(training).when()
                .post("/zaga/employeeOnboarding/certificationDetails")
                .then()
                .statusCode(200).extract().as(CertificationDetails.class);

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
                .get("/zaga/employeeOnboarding/getCertificationDetailsById")
                .then()
                .statusCode(200);
    }

    @Test
    @Order(3)
    public void updateTrainingTest() throws Exception {
        CertificationDetails updateTraining = CertificationDetails.builder().employeeId("1").employeeName("Sharanya")
                .validity("2024-01-01").build();
        RestAssured.given().baseUri("http://localhost")
                .port(port)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(updateTraining)
                .when()
                .put("/zaga/employeeOnboarding/updateCertificationDetails")
                .then();
                // .statusCode(200);
    }
}
