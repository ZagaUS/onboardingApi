package com.zaga.employee_onboarding.entity;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import com.zaga.employee_onboarding.entity.dto.EducationDetailsDTO;
import com.zaga.employee_onboarding.entity.dto.JobHistoryDTO;
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
    public String gender;
    public String nationality;
    public String maritalStatus;
    public String language;
    public String dateOfBirth;
    public String bloodGroup;
    public String personalEmail;
    public String personalPhone;
    public String emergencyPhone;
    public String address;

    // Job History Info
    public List<JobHistoryDTO> jobHistoryDetails;

    // Education Info
    public List<EducationDetailsDTO> educationDetails;

    // Skills Info
    public List<String> skillsName;
    public List<String> toolsName;
    public String yearsOfExperience;
    public String compentencyLevel;

    // Employee Documents
    public String fileName;
    public byte[] file;

    // DayOff
    public String allocatedLeave;
    public String used;
    public String balance;

    // Training
    public String courseName;
    public String certificationName;
    public String level;
    public String validity;

}
