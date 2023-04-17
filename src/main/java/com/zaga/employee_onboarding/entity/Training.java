package com.zaga.employee_onboarding.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "training")
public class Training {

    @Id
    public String employeeId;
    public String employeeName;
    public String courseName;
    public String certificationName;
    public String level;
    public String validity;
    
}
