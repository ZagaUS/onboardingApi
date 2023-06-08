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

import com.zaga.employee_onboarding.entity.PersonalInfo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

// import groovyjarjarantlr.collections.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PersonalInfoApiTest {

    private PersonalInfo result;

    @LocalServerPort
    int port;

    @Test
    @Order(1)

    public void testAddPersonalInfoTest() throws Exception {
        List<String> list = new ArrayList<String>();
        list.add("English");
        list.add("Tamil");
        PersonalInfo pi = PersonalInfo.builder().employeeId("1").employeeName("Suren").gender("male").nationality("Indian")
                .maritalStatus("single").language(list).dateOfBirth("1998-02-03").bloodGroup("A1+").personalEmail("surendar@gmail.com").personalPhone("7708521154").emergencyPhone("6385311793").address("617/5, Poornammal Colony, Kovilpatti").build();
        result = RestAssured.given()
                .baseUri("http://localhost")
                .port(port).contentType(ContentType.JSON).accept(ContentType.JSON).body(pi).when()
                .post("/zaga/employeeOnboarding/addPersonalInfo")
                .then()
                .statusCode(200).extract().as(PersonalInfo.class);

        System.out.println(result);
                
                    
    }

    @Test
    @Order(2)
    public void getPersonalInfoByIdTest() {
        RestAssured.given().baseUri("http://localhost")
                .port(port)
                .contentType(ContentType.JSON)
                .queryParam("employeeId", result.employeeId)
                .when()
                .get("/zaga/employeeOnboarding/getPersonalInfoById")
                .then()
                .statusCode(200);
    }

    @Test
    @Order(3)
    public void updatePersonalInfoTest() throws Exception { 
        PersonalInfo updatePI = PersonalInfo.builder().employeeId("1").employeeName("Suren").emergencyPhone("6380057418").build();
        RestAssured.given().baseUri("http://localhost").port(port).contentType(ContentType.JSON)
        .accept(ContentType.JSON).body(updatePI)
        .when().put("/zaga/employeeOnboarding/updatePersonalInfo")
        .then().statusCode(200);
}
}
