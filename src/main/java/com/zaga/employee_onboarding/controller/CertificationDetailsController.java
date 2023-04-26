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

import com.zaga.employee_onboarding.entity.CertificationDetails;
import com.zaga.employee_onboarding.service.CertificationDetailsService;

@RestController
public class CertificationDetailsController {
    
    @Autowired
    CertificationDetailsService certificationDetailsService;

    @PostMapping("/certificationDetails")
    public ResponseEntity<CertificationDetails> createTraining(@RequestBody CertificationDetails training) {
        CertificationDetails createCertificationDetails = certificationDetailsService.createTraining(training);
        return ResponseEntity.ok(createCertificationDetails);
    }

    @GetMapping("/getAllCertificationDetails")
    public ResponseEntity<List<CertificationDetails>> getAllTraining() {
        try {
            List<CertificationDetails> getAllcCertificationDetails = certificationDetailsService.getAllTraining();
            return ResponseEntity.ok(getAllcCertificationDetails);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/getCertificationDetailsById")
    public ResponseEntity<CertificationDetails> getTrainingById(@RequestParam String employeeId) {
        try {
            CertificationDetails getTrainingById = certificationDetailsService.getTrainingById(employeeId);
            return ResponseEntity.ok(getTrainingById);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/updateCertificationDetails")
    public ResponseEntity<CertificationDetails> updateTraining(@RequestParam String employeeId, @RequestBody CertificationDetails training) {
        try {
            CertificationDetails updateTraining = certificationDetailsService.updateTraining(employeeId, training);
            return ResponseEntity.ok(updateTraining);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
