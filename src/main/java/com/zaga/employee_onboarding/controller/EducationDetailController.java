package com.zaga.employee_onboarding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zaga.employee_onboarding.entity.EducationDetails;
import com.zaga.employee_onboarding.service.EducationDetailsService;

@RestController
public class EducationDetailController {

    @Autowired
    EducationDetailsService service;

    @PostMapping("/educationDetails/create")
    public ResponseEntity<EducationDetails> createEducationDetails(@RequestBody EducationDetails educationDetails) {
        EducationDetails createEducationDetails = service.createEducationalInfo(educationDetails);
        return ResponseEntity.ok(createEducationDetails);
    }

    @GetMapping("/getEducationDetailsById")
    public ResponseEntity<EducationDetails> getEducationDetailsById(String employeeId) {
        try {
            EducationDetails getEducationDetailsById = service.getEducationalnfoById(employeeId);
            return ResponseEntity.ok(getEducationDetailsById);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/updateEducationDetails")
    public ResponseEntity<EducationDetails> updateEducationDetails(
            EducationDetails educationDetails) {
        String employeeId = educationDetails.getEmployeeId();
        try {
            EducationDetails updateEducationDetails = service.updateEducationalInfo(employeeId, educationDetails);
            return ResponseEntity.ok(updateEducationDetails);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
