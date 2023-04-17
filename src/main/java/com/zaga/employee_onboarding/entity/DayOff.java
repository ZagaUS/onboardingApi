package com.zaga.employee_onboarding.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "dayoff")
public class DayOff {

    @Id
    public Object Id;
    public String employeeId;
    public String employeeName;
    public String allocatedLeave;
    public String used;
    public String balance;

}
