package com.zaga.employee_onboarding.controller;

import java.io.IOException;
import java.util.List;

import javax.websocket.server.PathParam;

// import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zaga.employee_onboarding.entity.EmployeeInfo;
import com.zaga.employee_onboarding.service.EmployeeInfoService;
import com.zaga.employee_onboarding.service.SequenceGeneratorService;

@RestController
// @CrossOrigin(origins = "http://localhost:8080")
public class EmployeeInfoController {
    @Autowired
    EmployeeInfoService employeeInfoService;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;

    @RequestMapping(path = "/createEmployeeInfo", method = RequestMethod.POST, consumes = {
            MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<?> addDetails(@RequestBody EmployeeInfo employeeInfo) {
        try {
            System.out.println("EmployeeInfo: " + employeeInfo);
            EmployeeInfo details = employeeInfoService.addDetails(employeeInfo);
            // employeeInfo.setEmployeeId(String.valueOf(sequenceGeneratorService.getNextSequence("sequenceName")));
            // employeeInfoService.addDetails(employeeInfo);
            return new ResponseEntity<>("Employee Details added successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("ERROR: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllEmployeeInfo")
    public ResponseEntity<List<EmployeeInfo>> getAllDetails() {
        try {
            List<EmployeeInfo> getAllDetailsList = employeeInfoService.getAllDetails();
            return ResponseEntity.ok(getAllDetailsList);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/getEmployeeInfo/{employeeId}")
    public ResponseEntity<EmployeeInfo> getDetailsById(@PathVariable String employeeId) {
        try {
            EmployeeInfo getDetailsById = employeeInfoService.getDetailsById(employeeId);
            return ResponseEntity.ok(getDetailsById);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/updateEmployeeInfo/{employeeId}")
    public ResponseEntity<EmployeeInfo> updateDetails(@PathVariable String employeeId,
            @RequestBody EmployeeInfo employeeInfo) {
        try {
            EmployeeInfo updateDetails = employeeInfoService.updateDetails(employeeId, employeeInfo);
            return ResponseEntity.ok(updateDetails);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
