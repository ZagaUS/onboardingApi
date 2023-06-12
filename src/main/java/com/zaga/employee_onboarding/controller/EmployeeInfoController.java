package com.zaga.employee_onboarding.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import com.zaga.employee_onboarding.entity.dto.UnassignedEmployeesDTO;
import com.zaga.employee_onboarding.repository.EmployeeInfoRepo;
import com.zaga.employee_onboarding.service.EmployeeInfoService;
import com.zaga.employee_onboarding.service.SequenceGeneratorService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class EmployeeInfoController {
    @Autowired
    EmployeeInfoService employeeInfoService;

    @Autowired
    EmployeeInfoRepo repo;

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

    @GetMapping("/getListOfInactiveEmployeeInfo")
    public List<UnassignedEmployeesDTO> getListOfInactiveEmployees() {

        List<EmployeeInfo> getEmployeeInfo = repo.getInactiveEmployeeInfo();
        List<UnassignedEmployeesDTO> unassignedEmployees = getEmployeeInfo.stream().map(employee -> {
            UnassignedEmployeesDTO listOfEmployeesDTO = new UnassignedEmployeesDTO();
            listOfEmployeesDTO.setEmployeeId(employee.getEmployeeId());
            listOfEmployeesDTO.setEmployeeName(employee.getEmployeeName());
            listOfEmployeesDTO.setEmployeeRole(employee.getEmployeeRole());
            listOfEmployeesDTO.setEmployeeEmail(employee.getEmployeeEmail());
            // listOfEmployeesDTO.setEmployeeNumber(employee.getEmplo);
            listOfEmployeesDTO.setProjectAssignmentStatus(employee.getProjectAssignmentStatus());

            return listOfEmployeesDTO;
        }).collect(Collectors.toList());
        return unassignedEmployees;
    }
    

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

    @DeleteMapping("/deleteEmployeeInfo/{employeeId}")
    public void deleteDetails(@PathVariable String employeeId) {
        employeeInfoService.deleteDetailsById(employeeId);
    }

}