package com.zaga.employee_onboarding.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainingDTO {
    public String courseName;
    public String certificationName;
    public String level;
    public String validity;
}
