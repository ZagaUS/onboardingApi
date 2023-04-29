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
@Document(collection = "trainingDetails")
public class TrainingDetails {
    
    @Id
    public String trainingId;
    public String trainingName;
    public String trainerName;
    public String traineeName;
    public String trainingStartDate;
    public String trainingEndDate;
    public List<TaskDTO> taskList;

}
