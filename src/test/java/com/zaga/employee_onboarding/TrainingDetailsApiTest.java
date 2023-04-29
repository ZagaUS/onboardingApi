package com.zaga.employee_onboarding;

import java.util.ArrayList;
import java.util.List;


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
import com.zaga.employee_onboarding.entity.Status;
import com.zaga.employee_onboarding.entity.TaskDTO;
import com.zaga.employee_onboarding.entity.TrainingDetails;
import com.zaga.employee_onboarding.entity.dto.JobHistoryDTO;

import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodProcess;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.MongodConfig;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class TrainingDetailsApiTest {
    private TrainingDetails responsebody;

    @LocalServerPort
    int port;
    
    @Test
    @Order(1)
    public void testCreate() throws Exception{

        List<TaskDTO> list = new ArrayList<>();
        TaskDTO dto = TaskDTO.builder().taskId("3").taskName("Git").description("Git installation").status(Status.NOTSTARTED).build();
        list.add(dto);
        TrainingDetails payload = TrainingDetails.builder()
            .trainingId("01").trainingName("quarkus").trainerName("raga").traineeName("pavi").trainingStartDate("01-03-2023").trainingEndDate("15-03-2023").taskList(list).build();

            responsebody=RestAssured.given()
                .baseUri("http://localhost")
                .port(port)
                .contentType(ContentType.JSON).accept(ContentType.JSON).body(payload).when()
                .post("trainingDetails")
                .then()
                .statusCode(200).extract().as(TrainingDetails.class);

            System.out.println(responsebody);


    }

    @Test
    @Order(2)
    void getTrainingDetailsByIdTest(){
        RestAssured.given().baseUri("http://localhost")
        .port(port)
        .contentType(ContentType.JSON)
        .queryParam("trainingId", responsebody.trainingId)
        .when()
        .get("/getTrainingDetailsById")
        .then()
        .statusCode(200);
        
    }
    
}
