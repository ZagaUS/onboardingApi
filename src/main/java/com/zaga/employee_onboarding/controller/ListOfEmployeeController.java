package com.zaga.employee_onboarding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zaga.employee_onboarding.entity.ListOfEmployee;
import com.zaga.employee_onboarding.service.ListOfEmployeeService;

@RestController
public class ListOfEmployeeController {

    @Autowired
    ListOfEmployeeService listOfEmployeeService;

    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<ListOfEmployee>> getAllEmployees() {
        try {
            List<ListOfEmployee> getAllEmployees = listOfEmployeeService.getAllEmployees();
            return ResponseEntity.ok(getAllEmployees);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
}
