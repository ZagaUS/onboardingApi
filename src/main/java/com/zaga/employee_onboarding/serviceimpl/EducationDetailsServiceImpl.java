package com.zaga.employee_onboarding.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaga.employee_onboarding.entity.EducationDetails;
import com.zaga.employee_onboarding.repository.EducationDetailsRepo;
import com.zaga.employee_onboarding.service.EducationDetailsService;

@Service
public class EducationDetailsServiceImpl implements EducationDetailsService {

    @Autowired
    EducationDetailsRepo repo;

    @Override
    public EducationDetails createEducationalInfo(EducationDetails dto) {
        EducationDetails info = repo.save(dto);
        return info;
    }

    @Override
    public List<EducationDetails> getEducationalnfo() {
        List<EducationDetails> getPersonalInfo = repo.findAll();
        return getPersonalInfo;
    }

    @Override
    public EducationDetails getEducationalnfoById(String employeeId) {
        EducationDetails getInfo = repo.getEducationalDetails(employeeId);
        return getInfo;
    }

    @Override
    public EducationDetails updateEducationalInfo(String employeeId, EducationDetails dto) {
        EducationDetails updatePersonalInfo = repo.getEducationalDetails(employeeId);
        dto.setId(updatePersonalInfo.getId());

        return repo.save(dto);
    }

}
