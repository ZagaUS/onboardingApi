package com.zaga.employeemangement.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaga.employeemangement.entity.DayOff;
import com.zaga.employeemangement.entity.EmployeeInfo;
import com.zaga.employeemangement.entity.PersonalInfo;
import com.zaga.employeemangement.entity.SkillInfo;
import com.zaga.employeemangement.entity.dto.EducationDTO;
import com.zaga.employeemangement.entity.dto.JobHistoryDTO;
import com.zaga.employeemangement.entity.dto.TrainingDTO;
import com.zaga.employeemangement.repository.DayOffRepo;
import com.zaga.employeemangement.repository.EducationRepo;
import com.zaga.employeemangement.repository.EmployeeInfoRepo;
import com.zaga.employeemangement.repository.JobHistoryRepo;
import com.zaga.employeemangement.repository.PersonalInfoRepo;
import com.zaga.employeemangement.repository.SkillInfoRepo;
import com.zaga.employeemangement.repository.TrainingRepo;
import com.zaga.employeemangement.service.EmployeeBoardingService;

@Service
public class EmployeeBoardingServiceImpl implements EmployeeBoardingService {

   @Autowired
   public EmployeeInfoRepo employeeInfoRepo;

   @Autowired
   public PersonalInfoRepo personalInfoRepo;

   @Autowired
   public SkillInfoRepo skillInfoRepo;

   @Autowired
   public EducationRepo educationRepo;

   @Autowired
   public JobHistoryRepo jobHistoryRepo;

   @Autowired
   public TrainingRepo trainingRepo;

   @Autowired
   public DayOffRepo dayOffRepo;

   @Override
   public String createEmployee(EmployeeInfo employeeInfo) {
      String employeeId = "1";

      // Generate the sequence number for employeeID

      // Persisting the Employee
      employeeInfo.setEmployeeId(employeeId);
      employeeInfoRepo.save(employeeInfo);

      PersonalInfo personalInfo = new PersonalInfo();
      personalInfo.setEmployeeId(employeeId);
      personalInfoRepo.save(personalInfo);

      SkillInfo skillInfo = new SkillInfo();
      skillInfo.setEmployeeId(employeeId);
      skillInfoRepo.save(skillInfo);

      EducationDTO educationInfo = new EducationDTO();
      educationInfo.setEmployeeId(employeeId);
      educationRepo.save(educationInfo);

      JobHistoryDTO jobHistoryInfo = new JobHistoryDTO();
      jobHistoryInfo.setEmployeeId(employeeId);
      jobHistoryRepo.save(jobHistoryInfo);

      TrainingDTO trainingInfo = new TrainingDTO();
      trainingInfo.setEmployeeId(employeeId);
      trainingRepo.save(trainingInfo);

      DayOff dayOffInfo = new DayOff();
      dayOffInfo.setEmployeeId(employeeId);
      dayOffRepo.save(dayOffInfo);

      return "Success";
   }

   @Override
   public String removeEmployee(String employeeId) {

      employeeInfoRepo.DeleteByEmpId(employeeId);

      personalInfoRepo.DeleteByEmpId(employeeId);

      skillInfoRepo.DeleteByEmpId(employeeId);

      educationRepo.DeleteByEmpId(employeeId);

      jobHistoryRepo.DeleteByEmpId(employeeId);

      trainingRepo.DeleteByEmpId(employeeId);

      dayOffRepo.DeleteByEmpId(employeeId);

      return "Success";
   }

}
