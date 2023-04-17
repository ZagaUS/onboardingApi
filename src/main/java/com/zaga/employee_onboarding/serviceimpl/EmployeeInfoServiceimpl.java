package com.zaga.employee_onboarding.serviceimpl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.zaga.employee_onboarding.entity.EmployeeInfo;
import com.zaga.employee_onboarding.repository.EmployeeInfoRepo;
import com.zaga.employee_onboarding.repository.SequenceGeneratorRepo;
import com.zaga.employee_onboarding.service.EmployeeInfoService;

@Service
public class EmployeeInfoServiceimpl implements EmployeeInfoService {

    @Autowired
    SequenceGeneratorRepo sequenceGeneratorRepo;

    @Autowired
    EmployeeInfoRepo employeeInfoRepo;

    @Override
    public EmployeeInfo addDetails(EmployeeInfo employeeInfo) throws IOException {

        // String empId = sequenceGeneratorRepo.getSequence("employee").getSeqNum().toString();
        // employeeInfo.setEmployeeId(empId);
        EmployeeInfo employeeInfo1 = employeeInfoRepo.save(employeeInfo);
        return employeeInfo1;

    }

    @Override
    public List<EmployeeInfo> getAllDetails() {
        List<EmployeeInfo> getEmployeeInfo = employeeInfoRepo.findAll();
        return getEmployeeInfo;
    }

    @Override
    public EmployeeInfo getDetailsById(String employeeId) {
        EmployeeInfo getEmployeeInfo = employeeInfoRepo.findById(employeeId).get();
        return getEmployeeInfo;
    }

    @Override
    public EmployeeInfo updateDetails(String employeeId, EmployeeInfo employeeInfo) {

        EmployeeInfo updateEmployeeInfo = employeeInfoRepo.findById(employeeId).get();
        updateEmployeeInfo.setEmployeeId(employeeInfo.getEmployeeId());
        updateEmployeeInfo.setEmployeeName(employeeInfo.getEmployeeName());
        updateEmployeeInfo.setEmployeeRole(employeeInfo.getEmployeeRole());
        updateEmployeeInfo.setJobTitle(employeeInfo.getJobTitle());
        updateEmployeeInfo.setDateOfJoining(employeeInfo.getDateOfJoining());
        updateEmployeeInfo.setEmployeeEmail(employeeInfo.getEmployeeEmail());
        updateEmployeeInfo.setPassword(employeeInfo.getPassword());
        updateEmployeeInfo.setDepartment(employeeInfo.getDepartment());
        updateEmployeeInfo.setReportingManager(employeeInfo.getReportingManager());
        updateEmployeeInfo.setEmployeeStatus(employeeInfo.getEmployeeStatus());
        updateEmployeeInfo.setOverallExperience(employeeInfo.getOverallExperience());
        updateEmployeeInfo.setProjectAssignmentStatus(employeeInfo.getProjectAssignmentStatus());
        return employeeInfoRepo.save(updateEmployeeInfo);
        
    }

}
