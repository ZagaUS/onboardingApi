package com.zaga.employee_onboarding.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.zaga.employee_onboarding.entity.dto.EducationDetailsDTO;
import com.zaga.employee_onboarding.entity.dto.JobHistoryDTO;
import com.zaga.employee_onboarding.entity.dto.PersonalInfo;
// import com.zaga.employee_onboarding.entity.dto.PdfObject;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "employeeInfo")

public class EmployeeInfo {

    // Employee Info
    @Id
    public String employeeId;
    public String employeeName;
    public String employeeRole;
    public String jobTitle;
    public String dateOfJoining;
    public String employeeEmail;
    public String password;
    public String department;
    public String reportingManager;
    public String employeeStatus;
    public Integer overallExperience;
    public Boolean projectAssignmentStatus;

    // Personal Info
    public PersonalInfo personalInfoDetails;

    // Job History Info
    public List<JobHistoryDTO> jobHistoryDetails;

    // Education Info
    public List<EducationDetailsDTO> educationDetails;
}
