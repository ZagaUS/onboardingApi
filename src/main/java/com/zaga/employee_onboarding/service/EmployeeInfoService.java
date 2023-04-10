package com.zaga.employee_onboarding.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.zaga.employee_onboarding.entity.EmployeeInfo;
import com.zaga.employee_onboarding.entity.dto.EducationDetailsDTO;
import com.zaga.employee_onboarding.entity.dto.JobHistoryDTO;

@Service
public interface EmployeeInfoService {

    public EmployeeInfo addDetails(EmployeeInfo employeeInfo) throws IOException;
    
    public List<EducationDetailsDTO> getEducationDetailsDTO();

    public String updateEmpDocuments(MultipartFile file) throws IOException;

    public List<JobHistoryDTO> getJobHistoryDTO();

}
