package com.zaga.employee_onboarding.service;

import org.springframework.stereotype.Service;

import com.zaga.employee_onboarding.entity.PersonalInfo;

@Service
public interface PersonalInfoService  {
    public  PersonalInfo getPersonalInfoDetails(String employeeId);

     public PersonalInfo updatePersonalInfo(String employeeId ,PersonalInfo personaldetails);

     public PersonalInfo createPersonalInfo(PersonalInfo personaldetails);
    
}
