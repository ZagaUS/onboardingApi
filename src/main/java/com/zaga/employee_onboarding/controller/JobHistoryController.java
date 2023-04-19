package com.zaga.employee_onboarding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zaga.employee_onboarding.entity.JobHistory;
import com.zaga.employee_onboarding.repository.JobHistoryRepo;
import com.zaga.employee_onboarding.service.JobHistoryService;

@RestController
public class JobHistoryController {
    @Autowired
    JobHistoryService service;

    @PostMapping("/jobHistory/create")
    public ResponseEntity<JobHistory> createJobHistory(@RequestBody JobHistory jobHistory) {
        JobHistory createJobHistory = service.createJobHistoryInfo(jobHistory);
        return ResponseEntity.ok(createJobHistory);
    }

    @GetMapping("/getJobHistoryById")
    public ResponseEntity<JobHistory> getJobHistoryById(String employeeId) {
        try {
            JobHistory getJobHistoryById = service.getJobHistorynfoById(employeeId);
            return ResponseEntity.ok(getJobHistoryById);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/updateJobHistory")
    public ResponseEntity<JobHistory> updateJobHistory(
            @RequestBody JobHistory jobHistory) {
        String employeeId = jobHistory.getEmployeeId();
        try {
            JobHistory updateJobHistory = service.updateJobHistoryInfo(employeeId, jobHistory);
            return ResponseEntity.ok(updateJobHistory);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
