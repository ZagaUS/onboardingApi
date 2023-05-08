package com.zaga.employee_onboarding.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zaga.employee_onboarding.entity.dto.EmployeeInfoDto;
import com.zaga.employee_onboarding.serviceimpl.EmployeeCreateServiceImpl;

@RestController
public class EmployeeController {
    

@Autowired
EmployeeCreateServiceImpl service;

    // @PostMapping("/createEmployee")
    // public ResponseEntity<?> createEmployee(@RequestBody EmployeeInfoDto dto) throws IOException{
    //        String createdEmployeeId = service.createEmployeeInfo(dto);
    //        return new ResponseEntity<>(createdEmployeeId,HttpStatus.CREATED);
    // } 

    @PostMapping("/createEmployee")
public ResponseEntity<?> createEmployee(@RequestBody EmployeeInfoDto employeeInfoDto) {
    try {
        // Your code here
        String createdEmployeeId = service.createEmployeeInfo(employeeInfoDto);
        // return ResponseEntity.ok().body("{ \"message\": \"Updated successfully\" }");
        return new ResponseEntity<>(createdEmployeeId,HttpStatus.CREATED);
    } catch(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
}


}
