package com.zaga.employee_onboarding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zaga.employee_onboarding.entity.PersonalInfo;
import com.zaga.employee_onboarding.service.PersonalInfoService;

@RestController
public class PersonalInfoController {
    @Autowired
    PersonalInfoService service;

    @PostMapping("/addPersonalInfo")
    public ResponseEntity<PersonalInfo> createPersonalInfo(@RequestBody PersonalInfo personalInfo) {
        PersonalInfo createPersonalInfo = service.createPersonalInfo(personalInfo);
        return ResponseEntity.ok(createPersonalInfo);
    }

    @GetMapping("/getPersonalInfo")
    public ResponseEntity<List<PersonalInfo>> getPersonalInfo() {
        try {
            List<PersonalInfo> getPersonalInfo = service.getPersonalnfo();
            return ResponseEntity.ok(getPersonalInfo);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/getPersonalInfoById")
    public ResponseEntity<PersonalInfo> getPersonalInfoById(String employeeId) {
        try {
            PersonalInfo getPersonalInfoById = service.getPersonalInfoById(employeeId);
            return ResponseEntity.ok(getPersonalInfoById);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/updatePersonalInfo")
    public ResponseEntity<PersonalInfo> updatePersonalInfo(@RequestBody PersonalInfo personalInfo) {
        String employeeId = personalInfo.getEmployeeId();
        try {
            PersonalInfo updatePersonalInfo = service.updatePersonalInfo(employeeId, personalInfo);
            return ResponseEntity.ok(updatePersonalInfo);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
