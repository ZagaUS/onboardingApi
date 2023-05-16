package com.zaga.employee_onboarding.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnassignedEmployeesDTO {
    public String employeeId;
    public String employeeName;
    // public String employeeNumber;
    public String employeeEmail;
    public String employeeRole;
    public Boolean projectAssignmentStatus;
}
