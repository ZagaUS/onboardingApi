// package com.zaga.employee_onboarding.repository;

// import static org.assertj.core.api.Assertions.assertThat;
// import static org.junit.jupiter.api.Assertions.assertThrows;

// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;
// import java.util.Optional;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.junit.jupiter.MockitoExtension;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
// import org.springframework.test.context.junit.jupiter.SpringExtension;

// import com.zaga.employee_onboarding.entity.EmployeeInfo;
// import com.zaga.employee_onboarding.entity.dto.EducationDetailsDTO;
// import com.zaga.employee_onboarding.entity.dto.JobHistoryDTO;

// @ExtendWith(SpringExtension.class)
// @ExtendWith(MockitoExtension.class)
// @DataMongoTest
// public class EmployeeInfoRepoTest {

//    @Autowired
//    private EmployeeInfoRepo employeeInfoRepo;

//    private EmployeeInfo employeeInfo;

//    @BeforeEach
//    public void setup() {
    
//     List<JobHistoryDTO> jobHistoryDetails = Arrays.asList(
//         new JobHistoryDTO("Company A", "Developer", "2020-01-01", "2022-01-01", "String"),
//         new JobHistoryDTO("Company B", "Senior Developer", "2018-01-01", "2020-01-01", "String")
//     );

//     List<EducationDetailsDTO> educationDetails = Arrays.asList(
//         new EducationDetailsDTO("String", "String", "String", "String", "String"),
//         new EducationDetailsDTO("String", "String", "String", "String", "String")
//     );

//     List<String> skillsName = new ArrayList<>();
//         skillsName.add("Java");
//         skillsName.add("SpringBoot");

//     List<String> toolsName = new ArrayList<>();
//         toolsName.add("VS Code");
//         toolsName.add("Postman");

//       employeeInfo = new EmployeeInfo("1", "raga", "String", "String", "String", "string", "String", "String", "String", "String", 2, true, "String", "String", "String", "String", "String", "String", "String", "String", "String", "String", jobHistoryDetails, educationDetails, skillsName, toolsName, "String", "String", "test.pdf", new byte[] { 1, 2, 3 }, "String", "String", "String", "String", "String", "String", "String");
//       employeeInfoRepo.save(employeeInfo);
//    }

//    @Test
//    public void testUpdateData() {
//       String updatedFileName = "test.pdf";
//       byte[] updatedFileData = new byte[] { 4, 5, 6 };
//       employeeInfoRepo.updateData(employeeInfo.getEmployeeId(), updatedFileName, updatedFileData);
//       Optional<EmployeeInfo> updatedEmployeeInfo = employeeInfoRepo.findById(employeeInfo.getEmployeeId());
//       assertThat(updatedEmployeeInfo).isPresent();
//       assertThat(updatedEmployeeInfo.get().getFileName()).isEqualTo(updatedFileName);
//       assertThat(updatedEmployeeInfo.get().getFile()).isEqualTo(updatedFileData);
//    }

//    @Test
//    public void testGetEmployeeInfo() {
//       Optional<EmployeeInfo> result = Optional.ofNullable(employeeInfoRepo.getEmployeeInfo(employeeInfo.getEmployeeId()));
//       assertThat(result).isPresent();
//       assertThat(result.get().getEmployeeId()).isEqualTo(employeeInfo.getEmployeeId());
//    }

//    @Test
//    public void testUpdateDataWithInvalidEmployeeId() {
//       assertThrows(Exception.class, () -> {
//          employeeInfoRepo.updateData("1", "test.pdf", new byte[] { 4, 5, 6 });
//       });
//    }

//    @Test
//    public void testUpdateDataWithInvalidFileName() {
//       assertThrows(Exception.class, () -> {
//          employeeInfoRepo.updateData(employeeInfo.getEmployeeId(), "test.pdf", new byte[] { 4, 5, 6 });
//       });
//    }

//    @Test
//    public void testUpdateDataWithNullFileData() {
//       assertThrows(Exception.class, () -> {
//          employeeInfoRepo.updateData(employeeInfo.getEmployeeId(), "test.pdf", new byte[] { 4, 5, 6 });
//       });
//    }

//    @Test
//    public void testGetEmployeeInfoWithInvalidEmployeeId() {
//       Optional<EmployeeInfo> result = Optional.ofNullable(employeeInfoRepo.getEmployeeInfo("invalidEmployeeId"));
//       assertThat(result).isEmpty();
//    }
// }