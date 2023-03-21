package com.zaga.employeemangement.entity.dto;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.zaga.employeemangement.entity.EducationInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "EducationInfo")
public class EducationDTO {

   public String employeeId;
   public List<EducationInfo> educationList;
}
