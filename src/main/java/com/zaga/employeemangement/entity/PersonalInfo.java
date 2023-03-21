package com.zaga.employeemangement.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "PersonalInfo")
public class PersonalInfo {

    public String employeeId;
    public String gender;
    public String nationality;
    public String maritalStatus;
    public String language;
    public String dateOfBirth;
    public String bloodGroup;
    public String personalEmail;
    public String personalPhone;
    public String emergencyPhone;

}
