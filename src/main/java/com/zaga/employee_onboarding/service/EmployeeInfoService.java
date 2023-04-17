package com.zaga.employee_onboarding.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
// import org.springframework.web.multipart.MultipartFile;

import com.zaga.employee_onboarding.entity.EmployeeInfo;

@Service
public interface EmployeeInfoService {

    public EmployeeInfo addDetails(EmployeeInfo employeeInfo) throws IOException;

    public List<EmployeeInfo> getAllDetails();

    public EmployeeInfo getDetailsById(String employeeId);

    public EmployeeInfo updateDetails(String employeeId, EmployeeInfo employeeInfo);
    
}
