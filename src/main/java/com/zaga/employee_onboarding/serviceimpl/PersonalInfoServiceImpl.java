package com.zaga.employee_onboarding.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaga.employee_onboarding.entity.dto.PersonalInfo;
import com.zaga.employee_onboarding.repository.PersonalInfoRepo;
import com.zaga.employee_onboarding.service.PersonalInfoService;

@Service
public class PersonalInfoServiceImpl implements PersonalInfoService {
  
    @Autowired
    PersonalInfoRepo repo;


    @Override
    public PersonalInfo getPersonalInfoDetails(String employeeId) {
        PersonalInfo info = repo.getPersonalnfo(employeeId);
        return info;
    }

    @Override
    public PersonalInfo updatePersonalInfo(String employeeId, PersonalInfo personaldetails) {
        PersonalInfo pi = repo.getPersonalnfo(employeeId);
        if (pi == null) {
            throw new RuntimeException("employee not found" + employeeId);
        }
        else{
            PersonalInfo info = pi;
            info.setId(pi.getId());
            info.setEmployeeName(personaldetails.getEmployeeName());
            info.setEmployeeId(personaldetails.getEmployeeId());
        info.setAddress(personaldetails.getAddress());
        info.setGender(personaldetails.getGender());
        info.setNationality(personaldetails.getNationality());
        info.setMaritalStatus(personaldetails.getMaritalStatus());
        info.setLanguage(personaldetails.getLanguage());
        info.setDateOfBirth(personaldetails.getDateOfBirth());
        info.setBloodGroup(personaldetails.getBloodGroup());
        info.setPersonalEmail(personaldetails.getPersonalEmail());
        info.setPersonalPhone(personaldetails.getPersonalPhone());
        info.setEmergencyPhone(personaldetails.getEmergencyPhone());
        return repo.save(info);
        }
    }

    @Override
    public PersonalInfo createPersonalInfo(PersonalInfo personaldetails) {

        return repo.save(personaldetails);
    }
    
}
