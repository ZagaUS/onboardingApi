package com.zaga.employeemangement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationInfo {

   public String collegeName;
   public String degree;
   public String specialization;
   public String year;
   public String graduate;

}
