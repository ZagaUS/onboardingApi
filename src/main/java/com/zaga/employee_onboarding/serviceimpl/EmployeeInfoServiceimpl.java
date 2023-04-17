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

}
