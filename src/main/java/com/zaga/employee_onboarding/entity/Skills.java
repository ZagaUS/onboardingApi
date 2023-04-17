package com.zaga.employee_onboarding.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "skills")
public class Skills {
    
    @Id
    public String employeeId;
    public String employeeName;
    public List<String> skillsName;
    public List<String> toolsName;
    public String yearsOfExperience;
    public String compentencyLevel;
    
}
