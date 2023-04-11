package com.zaga.employee_onboarding.serviceimpl;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.zaga.employee_onboarding.entity.EmployeeInfo;
import com.zaga.employee_onboarding.entity.dto.EducationDetailsDTO;
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
    public void updateEducationDetails(String employeeId, List<EducationDetailsDTO> educationDetailsDTO) {
        EmployeeInfo employeeInfo = employeeInfoRepo.findById(employeeId)
            .orElseThrow(() -> new RuntimeException("No employee found with id " + employeeId));

            List<EducationDetailsDTO> educationDetails = employeeInfo.getEducationDetails().stream()
                .map(edDTO -> {
                    EducationDetailsDTO ed = new EducationDetailsDTO();
                    ed.setCollegeName(edDTO.getCollegeName());
                    ed.setDegree(edDTO.getDegree());
                    ed.setSpecialization(edDTO.getSpecialization());
                    ed.setYear(edDTO.getYear());
                    ed.setGraduate(edDTO.getGraduate());
                    return ed;
                }).collect(Collectors.toList());

                employeeInfo.setEducationDetails(educationDetails);
                employeeInfoRepo.save(employeeInfo);
            
                // employeeInfo.updateEducationDetails(educationDetails);
                // employeeInfoRepo.save(employeeInfo);

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

}
