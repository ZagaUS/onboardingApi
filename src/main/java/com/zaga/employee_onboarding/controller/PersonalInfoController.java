package com.zaga.employee_onboarding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zaga.employee_onboarding.entity.PersonalInfo;
import com.zaga.employee_onboarding.service.PersonalInfoService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class PersonalInfoController {
    @Autowired
      PersonalInfoService service;

    @GetMapping("/getPersonalInfoDetails/{employeeId}")
    public PersonalInfo getPersonalInfoDetails(@PathVariable String employeeId){
        PersonalInfo pi = service.getPersonalInfoDetails(employeeId);
        return pi;
    }

    @PutMapping("/updatePersonalInfo/{employeeId}")
    public PersonalInfo updatePersonalInfo(@PathVariable String employeeId, PersonalInfo personalInfo){
      return service.updatePersonalInfo(employeeId, personalInfo);
    }

    @PostMapping("/createPersonalInfo")
    public PersonalInfo createPersonalInfo(@RequestBody PersonalInfo personalInfo){
       return service.createPersonalInfo(personalInfo);
    }

}
