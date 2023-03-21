package com.zaga.employeemangement.entity.dto;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.zaga.employeemangement.entity.Training;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "trainingInfo")
public class TrainingDTO {
   public String employeeId;
   public List<Training> trainingList;
}
