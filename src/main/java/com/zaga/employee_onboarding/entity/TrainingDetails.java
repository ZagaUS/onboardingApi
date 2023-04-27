package com.zaga.employee_onboarding.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"id"})
@Document(collection = "trainingDetails")
public class TrainingDetails {
    @Id
    public ObjectId id;
    public String trainingId;
    public String trainingName;
    public String trainerName;
    public String traineeName;
    public String trainingStartDate;
    public String trainingEndDate;

}
