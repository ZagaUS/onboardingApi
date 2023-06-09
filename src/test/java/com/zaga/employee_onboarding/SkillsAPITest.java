package com.zaga.employee_onboarding;

import java.util.ArrayList;
import java.util.List;

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

import com.zaga.employee_onboarding.entity.Skills;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SkillsAPITest {

    private Skills responsebody;

    @LocalServerPort
    int port;

    @Test
    @Order(1)
    public void testCreateSkills() throws Exception {
        List<String> list = new ArrayList<String>();
        list.add("Java");
        list.add("Javascript");

        List<String> list1 = new ArrayList<String>();
        list1.add("VS Code");
        list1.add("Postman");

        Skills skills = Skills.builder().employeeId("1").employeeName("Sharanya").skillsName(list)
                .toolsName(list1).yearsOfExperience("1").compentencyLevel("intermediate").build();
        
        responsebody = RestAssured.given()
                    .baseUri("http://localhost")
                    .port(port).contentType(ContentType.JSON).accept(ContentType.JSON).body(skills).when()
                .post("/zaga/employeeOnboarding/skills")
                .then()
                .statusCode(200).extract().as(Skills.class);

        System.out.println(responsebody);

    }

    @Test
    @Order(2)
    public void getSkillsByIdTest() {
        RestAssured.given().baseUri("http://localhost")
                .port(port)
                .contentType(ContentType.JSON)
                .queryParam("employeeId", responsebody.employeeId)
                .when()
                .get("/zaga/employeeOnboarding/getSkillsById")
                .then()
                .statusCode(200);
    }

    @Test
    @Order(3)
    public void updateSkillsTest() throws Exception {
        Skills skills = Skills.builder().employeeId("1").employeeName("Sharanya")
            .yearsOfExperience("1").build();

        RestAssured.given()
                    .baseUri("http://localhost")
                    .port(port).contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .body(skills)
                    .when()
                    .put("/zaga/employeeOnboarding/updateSkills")
                    .then()
                    .statusCode(200);
    }

}
