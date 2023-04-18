package com.zaga.employee_onboarding.entity.dto;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationDetailsDTO {
    public String collegeName;
    public String degree;
    public String specialization;
    public String year;
    public String graduate;

}
