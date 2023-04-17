package com.zaga.employee_onboarding.entity.dto;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "PersonalInfo")
public class PersonalInfo {

    @Id
    public ObjectId id;
    public String employeeId,employeeName;
    public String gender;
    public String nationality;
    public String maritalStatus;
    public String language;
    public String dateOfBirth;
    public String bloodGroup;
    public String personalEmail;
    public String personalPhone;
    public String emergencyPhone;
    public String address;
    

}
