package com.zaga.employee_onboarding.serviceimpl;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.zaga.employee_onboarding.entity.EmployeeInfo;
import com.zaga.employee_onboarding.entity.dto.EducationDetailsDTO;
import com.zaga.employee_onboarding.entity.dto.JobHistoryDTO;
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

        String empId = sequenceGeneratorRepo.getSequence("employee").getSeqNum().toString();
        employeeInfo.setEmployeeId(empId);
        EmployeeInfo employeeInfo1 = employeeInfoRepo.save(employeeInfo);
        return employeeInfo1;

    }

    @Override
    public List<EducationDetailsDTO> getEducationDetailsDTO() {

        List<EmployeeInfo> empInfo = employeeInfoRepo.findAll();

        if (empInfo.isEmpty()) {
            throw new RuntimeException("No records found");
        }

        List<List<EducationDetailsDTO>> educationDetailsList = empInfo.stream()
                .map(empInfos -> {
                    // List<EducationDetailsDTO> educationDetails = new
                    // ArrayList<EducationDetailsDTO>();
                    // educationDetails.setCollegeName(empInfos.getEducationDetails().stream().);
                    // educationDetails.setDegree(empInfos.getDegree());
                    // educationDetails.setSpecialization(empInfo.getSpecialization());
                    // educationDetails.setYear(empInfo.getYear());
                    // educationDetails.setGraduate(empInfo.getGraduate());

                    List<EducationDetailsDTO> educationDetails = empInfos.getEducationDetails().stream().map(ed -> {
                        EducationDetailsDTO edDTO = new EducationDetailsDTO();
                        edDTO.setCollegeName(ed.getCollegeName());
                        edDTO.setDegree(ed.getDegree());
                        edDTO.setSpecialization(ed.getSpecialization());
                        edDTO.setYear(ed.getYear());
                        edDTO.setGraduate(ed.getGraduate());
                        return edDTO;

                    }).collect(Collectors.toList());
                    return educationDetails;
                })
                .collect(Collectors.toList());

        return educationDetailsList.get(0);
    }

    @Override
    public String updateEmpDocuments(MultipartFile file) throws IOException {
        String fileName;
        byte[] fileData;

        fileName = file.getOriginalFilename();
        fileData = file.getBytes();

        System.out.println("File: " + fileName + " Data: " + fileData);

        employeeInfoRepo.updateData("2", fileName, fileData);

        return "success";
    }

    @Override
    public List<JobHistoryDTO> getJobHistoryDTO() {
        List<EmployeeInfo> empInfo = employeeInfoRepo.findAll();

        if (empInfo.isEmpty()) {
            throw new RuntimeException("No records found");
        }

        List<List<JobHistoryDTO>> jobHistorylist = empInfo.stream()
                .map(empInfos -> {

                    List<JobHistoryDTO> jobHistoryDetails = empInfos.getJobHistoryDetails().stream().map(jh -> {

                        JobHistoryDTO jhlDTO = new JobHistoryDTO();
                        jhlDTO.setCompanyName(jh.getCompanyName());
                        jhlDTO.setStartDate(jh.getStartDate());
                        jhlDTO.setEndDate(jh.getEndDate());
                        jhlDTO.setField(jh.getField());
                        jhlDTO.setExperience(jh.getExperience());

                        return jhlDTO;

                    }).collect(Collectors.toList());
                    return jobHistoryDetails;

                }).collect(Collectors.toList());
        return jobHistorylist.get(0);

    }

}
