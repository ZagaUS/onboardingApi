package com.zaga.employee_onboarding.entity.dto;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobHistoryDTO {
    public String companyName;
    public String startDate;
    public String endDate;
    public String field;
    public String experience;
}
