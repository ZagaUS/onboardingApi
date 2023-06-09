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

import com.zaga.employee_onboarding.entity.DayOff;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DayOffAPITest {

    private DayOff dayOffTest;

    @LocalServerPort
    int port;

    @Test
    @Order(1)

    public void createDayOffTest() throws Exception{
        DayOff df = DayOff.builder().employeeId("1").employeeName("Pavithra").allocatedLeave("10").used("8").balance("2").build();
        dayOffTest=RestAssured.given()
                .baseUri("http://localhost")
                .port(port).contentType(ContentType.JSON).accept(ContentType.JSON).body(df).when()
                .post("/zaga/employeeOnboarding/createDayOff")
                .then()
                .statusCode(200).extract().as(DayOff.class);
        System.out.println(dayOffTest);


       }

       @Test
       @Order(2)
       public void getDayOffById()
       {
        RestAssured.given().baseUri("http://localhost")
        .port(port)
        .contentType(ContentType.JSON)
        .queryParam("employeeId", dayOffTest.employeeId)
        .when()
        .get("/zaga/employeeOnboarding/getDayOffById")
        .then()
        .statusCode(200);
    }

    @Test
    @Order(3)
    public void updateDayOffTest() throws Exception{
        DayOff updateDF = DayOff.builder().employeeId("1").employeeName("pavi").allocatedLeave("15").build();
        RestAssured.given().baseUri("http://localhost").port(port).contentType(ContentType.JSON)
        .accept(ContentType.JSON).body(updateDF)
        .when().put("/zaga/employeeOnboarding/updateDayOff")
        .then()
        .statusCode(200);
    }
}

