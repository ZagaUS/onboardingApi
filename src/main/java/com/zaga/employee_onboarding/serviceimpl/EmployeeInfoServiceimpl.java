package com.zaga.employee_onboarding.serviceimpl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.zaga.employee_onboarding.entity.EmployeeInfo;
import com.zaga.employee_onboarding.repository.EmployeeInfoRepo;
import com.zaga.employee_onboarding.service.EmployeeInfoService;

@Service
public class EmployeeInfoServiceimpl implements EmployeeInfoService {

    @Autowired
    EmployeeInfoRepo employeeInfoRepo;

    @Override
    public EmployeeInfo addDetails(EmployeeInfo employeeInfo) throws IOException {

        EmployeeInfo employeeInfo1 = employeeInfoRepo.save(employeeInfo);
        return employeeInfo1;

    }

    @Override
    public String updateEmpDocuments(MultipartFile file) throws IOException {
        String fileName;
        byte[] fileData;

        fileName = file.getOriginalFilename();
        fileData = file.getBytes();

        System.out.println("File: " + fileName + " Data: " + fileData);

        // EmployeeInfo oldData = employeeInfoRepo.getEmployeeInfo("1");
        // System.out.println(" old data: " + oldData);
        // oldData.setFileName(fileName);
        // oldData.setFile(fileData);
        // employeeInfoRepo.save(oldData);

        employeeInfoRepo.updateData("2", fileName, fileData);

        return "success";
    }

}
