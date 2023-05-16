package com.zaga.employee_onboarding.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties("{id}")
public class MetaData {
    private String employeeId;
    private String employeeName;
    
    public String getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(String employeeId) {
        this.employeeId= employeeId;
    }
    public String getEmployeeName(String employeeName) {
        return employeeName;
    }
    public void setEmployeeName(String employeeName) {
        this.employeeName= employeeName;
    }

}
