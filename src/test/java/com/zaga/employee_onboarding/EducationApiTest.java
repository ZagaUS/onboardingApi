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

import com.zaga.employee_onboarding.entity.EducationDetails;
import com.zaga.employee_onboarding.entity.dto.EducationDetailsDTO;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EducationApiTest {
        private EducationDetails responsebody;

        @LocalServerPort
        int port;

        @Test
        @Order(1)
        public void testcreate() throws Exception {

                List<EducationDetailsDTO> list = new ArrayList<>();

                EducationDetailsDTO dto = EducationDetailsDTO.builder()
                                .collegeName("RVS college of Engineering ,Dindugal").degree("Btech")
                                .specialization("Mechanical")
                                .year("2020").graduate("YES").build();
                list.add(dto);

                EducationDetails payload = EducationDetails.builder()
                                .employeeId("101").employeeName("BALASUBRAMANIAN A").educationDetails(list).build();

                responsebody = RestAssured.given().baseUri("http://localhost").port(port).contentType(ContentType.JSON)
                                .accept(ContentType.JSON).body(payload)
                                .when().post("/zaga/employeeOnboarding/educationDetails/create")
                                .then().statusCode(200).extract().as(EducationDetails.class);
                System.out.println(responsebody);

        }

        @Test
        @Order(2)
        public void getEducationIfoByIdTest() {
                RestAssured.given().baseUri("http://localhost").port(port).contentType(ContentType.JSON)
                                .accept(ContentType.JSON)
                                .queryParam("employeeId", responsebody.employeeId).accept(ContentType.JSON)
                                .when().get("/zaga/employeeOnboarding/getEducationDetailsById")
                                .then().statusCode(200);
        }

        @Test
        @Order(3)
        public void testUpdate() {
                // update the education detail record
                EducationDetailsDTO updateDto = EducationDetailsDTO.builder().collegeName("New College").degree("MBA")
                                .specialization("Marketing").year("2022").graduate("YES").build();
                List<EducationDetailsDTO> updateList = new ArrayList<>();
                updateList.add(updateDto);

                EducationDetails updatePayload = EducationDetails.builder().employeeId("101")
                                .employeeName("BALASUBRAMANIAN A")
                                .educationDetails(updateList).build();

                RestAssured.given().baseUri("http://localhost").port(port).contentType(ContentType.JSON)
                                .accept(ContentType.JSON).body(updatePayload)
                                .when().put("/zaga/employeeOnboarding/updateEducationDetails")
                                .then().statusCode(200);

        }
}