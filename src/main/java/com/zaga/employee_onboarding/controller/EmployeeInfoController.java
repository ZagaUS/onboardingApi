package com.zaga.employee_onboarding.controller;

import java.util.List;


// import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zaga.employee_onboarding.entity.EmployeeInfo;
import com.zaga.employee_onboarding.entity.ListOfEmployeesDTO;
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
    public ResponseEntity<EmployeeInfo> addDetails(@RequestBody EmployeeInfo employeeInfo) {
        try {
            System.out.println("EmployeeInfo: " + employeeInfo);
            EmployeeInfo details = employeeInfoService.addDetails(employeeInfo);
            // employeeInfo.setEmployeeId(String.valueOf(sequenceGeneratorService.getNextSequence("sequenceName")));
            // employeeInfoService.addDetails(employeeInfo);
            return ResponseEntity.ok(details);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
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

    @GetMapping("/getListOfEmployeeInfo")
    public ResponseEntity<List<ListOfEmployeesDTO>> getListOfEmployees() {
        try {
            List<ListOfEmployeesDTO> getListOfEmployeeInfo = employeeInfoService.getListOfEmployees();
            return ResponseEntity.ok(getListOfEmployeeInfo);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // @GetMapping("/getListOfEmployeeInfo/{employeeId}")
    // public ResponseEntity<ListOfEmployeesDTO> getListOfEmployeesById(@PathVariable String employeeId) {
    //     try {
    //         ListOfEmployeesDTO getListOfEmployeeInfoById = employeeInfoService.getListOfEmployeesById(employeeId);
    //         return ResponseEntity.ok(getListOfEmployeeInfoById);
    //     } catch (Exception e) {
    //         return ResponseEntity.badRequest().build();
    //     }
    // }

    @GetMapping("/getEmployeeInfo")
    public ResponseEntity<EmployeeInfo> getDetailsById(@RequestParam String employeeId) {
        try {
            EmployeeInfo getDetailsById = employeeInfoService.getDetailsById(employeeId);
            return ResponseEntity.ok(getDetailsById);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/updateEmployeeInfo/{employeeId}")
    public ResponseEntity<EmployeeInfo> updateDetails(@PathVariable String employeeId, @RequestBody EmployeeInfo employeeInfo) {
        try {
            EmployeeInfo updateDetails = employeeInfoService.updateDetails(employeeId, employeeInfo);
            return ResponseEntity.ok(updateDetails);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}