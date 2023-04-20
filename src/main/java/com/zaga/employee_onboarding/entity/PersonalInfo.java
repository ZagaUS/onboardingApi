package com.zaga.employee_onboarding.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties ("{employeeId,employeeName}")
@Document(collection = "PersonalInfo")
public class PersonalInfo {

    @Id
    public String employeeId;
    public String employeeName;
    public String gender;
    public String nationality;
    public String maritalStatus;
    public List<String> language;
    public String dateOfBirth;
    public String bloodGroup;
    public String personalEmail;
    public String personalPhone;
    public String emergencyPhone;
    public String address;

}
