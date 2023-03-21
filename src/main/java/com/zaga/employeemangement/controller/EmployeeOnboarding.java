package com.zaga.employeemangement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zaga.employeemangement.entity.EmployeeInfo;
import com.zaga.employeemangement.service.EmployeeBoardingService;

@RestController
@RequestMapping("/EmployeeOnboarding")
public class EmployeeOnboarding {

   @Autowired
   EmployeeBoardingService employeeBoardingService;

   @PostMapping("/createEmployee")
   public ResponseEntity<?> createEmployee(@RequestBody EmployeeInfo employeeInfo) {
      try {
         String employee = employeeBoardingService.createEmployee(employeeInfo);
         return new ResponseEntity<>("Employee created successfully", HttpStatus.OK);
      } catch (Exception e) {
         return new ResponseEntity<>("ERROR: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
      }
   }

   @DeleteMapping("/RemoveEmployee")
   public ResponseEntity<?> removeEmployee(@RequestParam String employeeId) {
      try {
         String employee = employeeBoardingService.removeEmployee(employeeId);
         return new ResponseEntity<>("Employee removed successfully", HttpStatus.OK);
      } catch (Exception e) {
         return new ResponseEntity<>("ERROR: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
      }
   }

}
