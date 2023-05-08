package com.zaga.employee_onboarding.serviceimpl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaga.employee_onboarding.entity.EducationDetails;
import com.zaga.employee_onboarding.entity.EmployeeInfo;
import com.zaga.employee_onboarding.entity.JobHistory;
import com.zaga.employee_onboarding.entity.PersonalInfo;
import com.zaga.employee_onboarding.entity.Skills;
import com.zaga.employee_onboarding.entity.dto.EmployeeInfoDto;
import com.zaga.employee_onboarding.service.EducationDetailsService;
import com.zaga.employee_onboarding.service.EmployeeInfoService;
import com.zaga.employee_onboarding.service.JobHistoryService;
import com.zaga.employee_onboarding.service.PersonalInfoService;
import com.zaga.employee_onboarding.service.SequenceGeneratorService;
import com.zaga.employee_onboarding.service.SkillsService;

@Service
public class EmployeeCreateServiceImpl {

    @Autowired
    EmployeeInfoService employeeInfoService;

    @Autowired
    PersonalInfoService personalInfoService;

    @Autowired
    JobHistoryService jobHistoryService;

    @Autowired
    SkillsService skillsService;

    @Autowired
    EducationDetailsService educationDetailsService;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;

    public String createEmployeeInfo(EmployeeInfoDto employeeInfoDto) throws IOException {
        String employeeid = sequenceGeneratorService.getNextSequence("Employee");
        // String employeename = employeeInfoDto.getEmployeeInfo().getEmployeeName();

        if (employeeInfoDto != null && employeeInfoDto.getEmployeeInfo() != null) {
            String employeename = employeeInfoDto.getEmployeeInfo().getEmployeeName();
            // Rest of your code here
        }
        else {
            return "INTERNAL_SERVER_ERROR";
        }
        

        // employee info
        EmployeeInfo employeeObj = employeeInfoDto.getEmployeeInfo();

        employeeObj.setEmployeeId(employeeid);

        EmployeeInfo employeeInfo = employeeInfoService.addDetails(employeeObj);

        // personal info
        PersonalInfo personalObj = employeeInfoDto.getPersonalInfo();

        personalObj.setEmployeeId(employeeid);

        // personalObj.setEmployeeName(employeename);
        personalObj.setEmployeeName(employeeInfoDto.getEmployeeInfo().getEmployeeName());

        PersonalInfo personalInfo = personalInfoService.createPersonalInfo(personalObj);

        // skill
        Skills skillsObj = employeeInfoDto.getSkills();

        skillsObj.setEmployeeId(employeeid);

        Skills skills = skillsService.createSkills(skillsObj);

        // education info

        EducationDetails educationDetails = new EducationDetails();
        educationDetails.setEducationDetails(employeeInfoDto.getEducationDetails());
        educationDetails.setEmployeeId(employeeid);
        // educationDetails.setEmployeeName(employeename);
        educationDetails.setEmployeeName(employeeInfoDto.getEmployeeInfo().getEmployeeName());
        EducationDetails result = educationDetailsService.createEducationalInfo(educationDetails);

        // job history
        JobHistory jobHistory = new JobHistory();
        jobHistory.setEmployeeId(employeeid);
        // jobHistory.setEmployeeName(employeename);
        jobHistory.setEmployeeName(employeeInfoDto.getEmployeeInfo().getEmployeeName());
        jobHistory.setJobHistoryDetails(employeeInfoDto.getJobHistoryDetails());
        JobHistory results = jobHistoryService.createJobHistoryInfo(jobHistory);

        return employeeid;

    }
}
