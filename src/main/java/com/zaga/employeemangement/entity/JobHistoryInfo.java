package com.zaga.employeemangement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobHistoryInfo {

   public String companyName;
   public String startDate;
   public String endDate;
   public String field;
   public String experience;

}
