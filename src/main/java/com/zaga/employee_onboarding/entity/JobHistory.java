package com.zaga.employee_onboarding.entity;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import com.zaga.employee_onboarding.entity.dto.JobHistoryDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "JobHistory")
public class JobHistory {

    public ObjectId id;

    public String employeeId;
    public String employeeName;
    public List<JobHistoryDTO> jobHistoryDetails;
}
