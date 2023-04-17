package com.zaga.employee_onboarding.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zaga.employee_onboarding.entity.PersonalInfo;

@Service
public interface PersonalInfoService  {
    
    public PersonalInfo createPersonalInfo(PersonalInfo personalInfo);

    public List<PersonalInfo> getPersonalnfo();

    public PersonalInfo getPersonalInfoById(String employeeId);

    public PersonalInfo updatePersonalInfo(String employeeId ,PersonalInfo personalInfo);
    
}
