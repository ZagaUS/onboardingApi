package com.zaga.employee_onboarding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zaga.employee_onboarding.entity.TrainingDetails;
import com.zaga.employee_onboarding.service.TrainingDetailsService;

// @CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class TrainingDetailsController {
    @Autowired
    TrainingDetailsService trainingDetailsService;

    @PostMapping("/trainingDetails")
    public ResponseEntity<TrainingDetails> createTrainingDetails(@RequestBody TrainingDetails trainingDetails) {
        TrainingDetails createTrainingDetails = trainingDetailsService.createTrainingDetails(trainingDetails);
        return ResponseEntity.ok(createTrainingDetails);
    }

    @GetMapping("/getAllTrainingDetails")
    public ResponseEntity<List<TrainingDetails>> getAllTrainingDetails() {
        try {
            List<TrainingDetails> getAllTrainingDetails = trainingDetailsService.getAllTrainingDetails();
            return ResponseEntity.ok(getAllTrainingDetails);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/getTrainingDetailsById")
    public ResponseEntity<TrainingDetails> getTrainingDetailsById(String trainingId) {
        try {
            TrainingDetails getTrainingDetailsById = trainingDetailsService.getTrainingDetailsById(trainingId);
            return ResponseEntity.ok(getTrainingDetailsById);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/updateTrainingDetails")
    public ResponseEntity<TrainingDetails> updateTrainingDetails(@RequestBody TrainingDetails trainingDetails) {
        String trainingId = trainingDetails.getTrainingId();
        try {
            TrainingDetails updateTrainingDetails = trainingDetailsService.updateTrainingDetails(trainingId, trainingDetails);
            return ResponseEntity.ok(updateTrainingDetails);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
