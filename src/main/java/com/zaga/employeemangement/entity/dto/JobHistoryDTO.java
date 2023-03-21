package com.zaga.employeemangement.entity.dto;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.zaga.employeemangement.entity.JobHistoryInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "jobHistoryInfo")
public class JobHistoryDTO {

   public String employeeId;
   public List<JobHistoryInfo> jobs;
   public String overallExperience;

}
