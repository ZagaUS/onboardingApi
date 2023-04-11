package com.zaga.employee_onboarding.controller;

import java.io.IOException;

// import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zaga.employee_onboarding.entity.EmployeeInfo;
import com.zaga.employee_onboarding.service.EmployeeInfoService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class EmployeeInfoController {
    @Autowired
    EmployeeInfoService employeeInfoService;

    @RequestMapping(path = "/employeeInfo", method = RequestMethod.POST, consumes = {
            MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<?> addDetails(@RequestBody EmployeeInfo employeeInfo) {
        try {
            System.out.println("EmployeeInfo: " + employeeInfo);
            EmployeeInfo details = employeeInfoService.addDetails(employeeInfo);
            return new ResponseEntity<>("Employee Details added successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("ERROR: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getEducationDetails")
    public ResponseEntity<?> getEducationDetails() {
        try {

            return new ResponseEntity<>(employeeInfoService.getEducationDetailsDTO(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("ERROR: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateEducationDetails")
    public ResponseEntity<?> updateEducationDetails(@RequestParam(value = "employeeId", required = true) String employeeId,
            @RequestBody EmployeeInfo employeeInfo) {
        try {
            employeeInfoService.updateEducationDetails(employeeId, employeeInfo.getEducationDetails());
            return new ResponseEntity<>("Employee Details updated successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("ERROR: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "uploadDocuments", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> handleFileUpload(@RequestParam(value = "file", required = true) MultipartFile file)
            throws IOException {
        String fileupdate = employeeInfoService.updateEmpDocuments(file);
        return ResponseEntity.ok("File uploaded successfully.");
    }

}
