package com.zaga.employeemangement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Training {
   public String courseName;
   public String year;
   public String certificationName;
   public String level;
   public String validity;
}
