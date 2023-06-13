package com.zaga.employee_onboarding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zaga.employee_onboarding.entity.CertificationDetails;
import com.zaga.employee_onboarding.service.CertificationDetailsService;

// @CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class CertificationDetailsController {
    
    @Autowired
    CertificationDetailsService certificationDetailsService;

    @PostMapping("/certificationDetails")
    public ResponseEntity<CertificationDetails> createCertificationDetails(@RequestBody CertificationDetails certificationDetails) {
        CertificationDetails createCertificationDetails = certificationDetailsService.createCertificationDetails(certificationDetails);
        return ResponseEntity.ok(createCertificationDetails);
    }

    @GetMapping("/getAllCertificationDetails")
    public ResponseEntity<List<CertificationDetails>> getAllCertificationDetails() {
        try {
            List<CertificationDetails> getAllCertificationDetails = certificationDetailsService.getAllCertificationDetails();
            return ResponseEntity.ok(getAllCertificationDetails);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/getCertificationDetailsById")
    public ResponseEntity<CertificationDetails> getCertificationDetailsById(@RequestParam String employeeId) {
        try {
            CertificationDetails getCertificationDetailsById = certificationDetailsService.getCertificationDetailsById(employeeId);
            return ResponseEntity.ok(getCertificationDetailsById);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/updateCertificationDetails")
    public ResponseEntity<CertificationDetails> updateCertificationDetails(@RequestParam String employeeId, @RequestBody CertificationDetails certificationDetails) {
        try {
            CertificationDetails updateCertificationDetails = certificationDetailsService.updateCertificationDetails(employeeId, certificationDetails);
            return ResponseEntity.ok(updateCertificationDetails);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
