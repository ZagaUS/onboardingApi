package com.zaga.employee_onboarding.entity.dto;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "educationDetailsInfo")
public class EducationDetailsDTO {
    public String collegeName;
    public String degree;
    public String specialization;
    public String year;
    public String graduate;

}
