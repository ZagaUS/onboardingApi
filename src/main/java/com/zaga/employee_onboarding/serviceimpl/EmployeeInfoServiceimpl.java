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
import com.zaga.employee_onboarding.entity.dto.EducationDetailsDTO;
import com.zaga.employee_onboarding.entity.dto.JobHistoryDTO;
import com.zaga.employee_onboarding.entity.dto.PersonalInfo;
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

        List<List<EducationDetailsDTO>> educationDetailsList = empInfo.stream().map(empInfos -> {

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

    @Override
    public void updateJobHistoryDTO(String employeeId, List<JobHistoryDTO> jobhistoryDTO) {

        EmployeeInfo employeeInfo = employeeInfoRepo.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("No employee found with id " + employeeId));

        List<JobHistoryDTO> jobhistory = employeeInfo.getJobHistoryDetails().stream()
                .map(jhDTO -> {
                    JobHistoryDTO jhd = new JobHistoryDTO();
                    jhd.setCompanyName(jhDTO.getCompanyName());
                    jhd.setStartDate(jhDTO.getStartDate());
                    jhd.setEndDate(jhDTO.getEndDate());
                    jhd.setField(jhDTO.getField());
                    jhd.setExperience(jhDTO.getExperience());
                    return jhd;
                }).collect(Collectors.toList());

        employeeInfo.setJobHistoryDetails(jobhistory);
        employeeInfoRepo.save(employeeInfo);
    }

    @Override
    public PersonalInfo getPersonalInfoDetails(String employeeId) {
        EmployeeInfo info = employeeInfoRepo.getEmployeeInfo(employeeId);
        return info.getPersonalInfoDetails();
    }

    @Override
    public PersonalInfo updatePersonalInfo(String employeeId, PersonalInfo personaldetails) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatePersonalInfo'");
    }

    // @Override
    // public PersonalInfo updatePersonalInfo(String employeeId, PersonalInfo personaldetails) {
    //     PersonalInfo info = employeeInfoRepo.findById(employeeId).orElse(null);
    //     if (info == null) {
    //         throw new RuntimeException("employee not found" + employeeId);
    //     }
    //     info.setAddress(personaldetails.getAddress());
    //     info.setGender(personaldetails.getGender());
    //     info.setNationality(personaldetails.getNationality());
    //     info.setMaritalStatus(personaldetails.getMaritalStatus());
    //     info.setLanguage(personaldetails.getLanguage());
    //     info.setDateOfBirth(personaldetails.getDateOfBirth());
    //     info.setBloodGroup(personaldetails.getBloodGroup());
    //     info.setPersonalEmail(personaldetails.getPersonalEmail());
    //     info.setPersonalPhone(personaldetails.getPersonalPhone());
    //     info.setEmergencyPhone(personaldetails.getEmergencyPhone());
    //     return employeeInfoRepo.save(info);
    // }

    // @Override
    // public EmployeeInfo employeeInfo(String employeeId) {
    // throw new UnsupportedOperationException("Unimplemented method
    // 'employeeInfo'");
    // }

    // @Override
    // public List<PersonalDTO> getPersonalDetailsDTO() {

    // List<EmployeeInfo> empInfo = employeeInfoRepo.findAll();

    // if (empInfo.isEmpty()) {
    // throw new RuntimeException("No records found");
    // }

    // List<List<PersonalDTO>> personalInfoDetailslist =
    // empInfo.stream().map(empInfos ->
    // {

    // List<PersonalDTO> personalInfoDetails =
    // empInfos.getPersonalDTO().stream().map(pifo -> {
    // PersonalDTO personaldto = new PersonalDTO();

    // personaldto.setAddress(pifo.getAddress());
    // personaldto.setGender(pifo.getGender());
    // personaldto.setNationality(pifo.getNationality());
    // personaldto.setMaritalStatus(pifo.getMaritalStatus());
    // personaldto.setLanguage(pifo.getLanguage());
    // personaldto.setDateOfBirth(pifo.getDateOfBirth());
    // personaldto.setBloodGroup(pifo.getBloodGroup());
    // personaldto.setPersonalEmail(pifo.getPersonalEmail());
    // personaldto.setPersonalPhone(pifo.getPersonalPhone());
    // personaldto.setEmergencyPhone(pifo.getEmergencyPhone());
    // return personaldto;
    // }).collect(Collectors.toList());
    // return personalInfoDetails;
    // }).collect(Collectors.toList());
    // return personalInfoDetailslist.get(0);
    // }

}
