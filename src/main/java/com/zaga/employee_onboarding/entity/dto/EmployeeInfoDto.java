package com.zaga.employee_onboarding.entity.dto;

import java.util.List;

import com.zaga.employee_onboarding.entity.EducationDetails;
import com.zaga.employee_onboarding.entity.EmployeeInfo;
import com.zaga.employee_onboarding.entity.JobHistory;
import com.zaga.employee_onboarding.entity.PersonalInfo;
import com.zaga.employee_onboarding.entity.Skills;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class EmployeeInfoDto {
  // employee info
    public EmployeeInfo employeeInfo;
    

    // personal Info
    public PersonalInfo personalInfo;

    // education details
    public List<EducationDetailsDTO> educationDetails;

    // job history info
    public List<JobHistoryDTO> jobHistoryDetails;

    // skill
     public Skills skills;

    // training

    // day off




}
