package com.zaga.employee_onboarding.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListOfEmployeesDTO {
    public String employeeId;
    public String employeeName;
    public String employeeRole;
    public Boolean projectAssignmentStatus;
}
