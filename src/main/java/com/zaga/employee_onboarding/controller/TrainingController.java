package com.zaga.employee_onboarding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zaga.employee_onboarding.entity.Training;
import com.zaga.employee_onboarding.service.TrainingService;

@RestController
public class TrainingController {
    
    @Autowired
    TrainingService trainingService;

    @PostMapping("/training")
    public ResponseEntity<Training> createTraining(@RequestBody Training training) {
        Training createTraining = trainingService.createTraining(training);
        return ResponseEntity.ok(createTraining);
    }

    @GetMapping("/getAllTraining")
    public ResponseEntity<List<Training>> getAllTraining() {
        try {
            List<Training> getAllTrainingList = trainingService.getAllTraining();
            return ResponseEntity.ok(getAllTrainingList);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/getTrainingById")
    public ResponseEntity<Training> getTrainingById(@RequestParam String employeeId) {
        try {
            Training getTrainingById = trainingService.getTrainingById(employeeId);
            return ResponseEntity.ok(getTrainingById);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/updateTraining")
    public ResponseEntity<Training> updateTraining(@RequestParam String employeeId, @RequestBody Training training) {
        try {
            Training updateTraining = trainingService.updateTraining(employeeId, training);
            return ResponseEntity.ok(updateTraining);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
