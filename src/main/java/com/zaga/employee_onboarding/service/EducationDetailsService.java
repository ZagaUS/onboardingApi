package com.zaga.employee_onboarding.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zaga.employee_onboarding.entity.EducationDetails;

@Service
public interface EducationDetailsService {
    EducationDetails createEducationalInfo(EducationDetails dto);

    List<EducationDetails> getEducationalnfo();

    EducationDetails getEducationalnfoById(String employeeId);

    EducationDetails updateEducationalInfo(String employeeId, EducationDetails dto);

    public void deleteEducationalInfoById(String employeeId);

}
