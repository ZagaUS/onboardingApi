package com.zaga.employee_onboarding.entity;

import java.util.List;

import org.bson.types.Binary;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.zaga.employee_onboarding.entity.dto.EducationDetailsDTO;
import com.zaga.employee_onboarding.entity.dto.JobHistoryDTO;
import com.zaga.employee_onboarding.entity.dto.PersonalInfo;
// import com.zaga.employee_onboarding.entity.dto.PdfObject;
import com.zaga.employee_onboarding.entity.dto.TrainingDTO;

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
    public List<TrainingDTO> trainingDetails;


}
