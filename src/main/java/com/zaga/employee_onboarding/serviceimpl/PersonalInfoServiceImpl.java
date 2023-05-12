package com.zaga.employee_onboarding.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaga.employee_onboarding.entity.PersonalInfo;
import com.zaga.employee_onboarding.repository.PersonalInfoRepo;
import com.zaga.employee_onboarding.service.PersonalInfoService;

@Service
public class PersonalInfoServiceImpl implements PersonalInfoService {
  
    @Autowired
    PersonalInfoRepo personalInfoRepo;

    @Override
    public PersonalInfo createPersonalInfo(PersonalInfo personalInfo) {
        PersonalInfo info = personalInfoRepo.save(personalInfo);
        return info;
    }

    @Override
    public List<PersonalInfo> getPersonalInfo() {
        List<PersonalInfo> getPersonalInfo = personalInfoRepo.findAll();
        return getPersonalInfo;
    }

    @Override
    public PersonalInfo getPersonalInfoById(String employeeId) {
        PersonalInfo getInfo = personalInfoRepo.findById(employeeId).orElse(null);
        return getInfo;
    }

    @Override
    public PersonalInfo updatePersonalInfo(String employeeId ,PersonalInfo personalInfo) {
        PersonalInfo updatePersonalInfo = personalInfoRepo.findById(employeeId).get();
        updatePersonalInfo.setGender(personalInfo.getGender());
        updatePersonalInfo.setNationality(personalInfo.getNationality());
        updatePersonalInfo.setMaritalStatus(personalInfo.getMaritalStatus());
        updatePersonalInfo.setLanguage(personalInfo.getLanguage());
        updatePersonalInfo.setDateOfBirth(personalInfo.getDateOfBirth());
        updatePersonalInfo.setBloodGroup(personalInfo.getBloodGroup());
        updatePersonalInfo.setPersonalEmail(personalInfo.getPersonalEmail());
        updatePersonalInfo.setPersonalPhone(personalInfo.getPersonalPhone());
        updatePersonalInfo.setEmergencyPhone(personalInfo.getEmergencyPhone());
        updatePersonalInfo.setAddress(personalInfo.getAddress());
        return personalInfoRepo.save(updatePersonalInfo);
    }

    @Override
    public void deletePersonalInfo(String employeeId) {
        personalInfoRepo.deleteById(employeeId);
    }
    
}
