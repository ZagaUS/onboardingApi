package com.zaga.employeemangement.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "dayOffInfo")
public class DayOff {
   public String employeeId;
   public String allocatedLeave;
   public String used;
   public String balance;
   public String year;
}
