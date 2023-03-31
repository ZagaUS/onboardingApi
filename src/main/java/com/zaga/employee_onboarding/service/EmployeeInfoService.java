package com.zaga.employee_onboarding.service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.zaga.employee_onboarding.entity.EmployeeInfo;

@Service
public interface EmployeeInfoService {

    public EmployeeInfo addDetails(EmployeeInfo employeeInfo) throws IOException;

    public String updateEmpDocuments(MultipartFile file) throws IOException;
}
