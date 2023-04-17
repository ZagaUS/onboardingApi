// package com.zaga.employee_onboarding.controller;

// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.Mockito.mock;
// import static org.mockito.Mockito.when;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// import java.nio.charset.StandardCharsets;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.springframework.http.MediaType;
// import org.springframework.mock.web.MockMultipartFile;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.ResultActions;
// import org.springframework.test.web.servlet.setup.MockMvcBuilders;

// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.zaga.employee_onboarding.entity.EmployeeInfo;
// import com.zaga.employee_onboarding.service.EmployeeInfoService;

// public class EmployeeInfoControllerTest {
//     @InjectMocks
//     private EmployeeInfoService employeeInfoService;

//     @Mock
//     private EmployeeInfoController employeeInfoController;

//     @Mock
//     private MockMvc mockMvc;

//     @BeforeEach
//     public void setup() {
//         employeeInfoService = mock(EmployeeInfoService.class);
//         employeeInfoController = new EmployeeInfoController();
//         mockMvc = MockMvcBuilders.standaloneSetup(employeeInfoController).build();
//     }

//     @Test
//     public void addDetailsShouldReturnOk() throws Exception {
//         // Given
//         EmployeeInfo employeeInfo = new EmployeeInfo();
//         employeeInfo.setEmployeeId("1");
//         employeeInfo.setEmployeeName("raga");
//         employeeInfo.setFileName("BR3_My_Personal_Stress_Plan.pdf");
//         employeeInfo.setFile(new byte[] { 1, 2, 3 });
//         when(employeeInfoService.addDetails(any(EmployeeInfo.class))).thenReturn(employeeInfo);

//         // When
//         ResultActions result = mockMvc.perform(post("/employeeInfo")
//                 .contentType(MediaType.APPLICATION_JSON)
//                 .content(new ObjectMapper().writeValueAsString(employeeInfo))
//                 .characterEncoding(StandardCharsets.UTF_8.name()));

//         // Then
//         result.andExpect(status().isOk());
//     }

//     @Test
//     public void handleFileUploadShouldReturnOk() throws Exception {
//         // Given
//         byte[] fileContent = "Hello World".getBytes();
//         MockMultipartFile file = new MockMultipartFile("file", "BR3_My_Personal_Stress_Plan.pdf", "application/pdf", fileContent);
//         when(employeeInfoService.updateEmpDocuments(file)).thenReturn("BR3_My_Personal_Stress_Plan.pdf");

//         // When
//         ResultActions result = mockMvc.perform(multipart("/uploadDocuments")
//                 .file(file)
//                 .contentType(MediaType.MULTIPART_FORM_DATA)
//                 .characterEncoding(StandardCharsets.UTF_8.name()));

//         // Then
//         result.andExpect(status().isOk());
//     }
// }
