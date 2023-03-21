package com.zaga.employeemangement.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "SkillInfo")
public class SkillInfo {

   public String employeeId;
   public List<String> skillsName;
   public List<String> toolsName;
   public String yearsOfExperience;
   public String compentencyLevel;

}
