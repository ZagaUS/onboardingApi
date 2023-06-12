package com.zaga.employee_onboarding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zaga.employee_onboarding.entity.dto.EmployeeInfoDto;
import com.zaga.employee_onboarding.serviceimpl.EmployeeCreateServiceImpl;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class EmployeeController {
    

@Autowired
EmployeeCreateServiceImpl service;

    @RequestMapping(path = "/createEmployee", method = RequestMethod.POST, consumes = {
        MediaType.APPLICATION_JSON_VALUE })

    public ResponseEntity<?> createEmployee(@RequestBody EmployeeInfoDto employeeInfoDto) {
        try {
            String createdEmployeeId = service.createEmployeeInfo(employeeInfoDto);
            return new ResponseEntity<>(createdEmployeeId,HttpStatus.CREATED);
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/deleteEmployee")
    public void deleteEmployee(String employeeId) {
        service.deleteEmployeeInfo(employeeId);
    }

}
