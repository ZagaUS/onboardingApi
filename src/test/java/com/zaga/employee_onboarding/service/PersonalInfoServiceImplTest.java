package com.zaga.employee_onboarding.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.zaga.employee_onboarding.entity.PersonalInfo;
import com.zaga.employee_onboarding.repository.PersonalInfoRepo;
import com.zaga.employee_onboarding.serviceimpl.PersonalInfoServiceImpl;

@ExtendWith(MockitoExtension.class)
public class PersonalInfoServiceImplTest {
    
    @Mock
    PersonalInfoRepo personalInfoRepo;

    @InjectMocks
    PersonalInfoServiceImpl personalInfoServiceimpl;

    public PersonalInfo anushiya;
    public PersonalInfo pavithra;

    @BeforeEach
    void init() {
        anushiya = new PersonalInfo();
        anushiya.setEmployeeId("1");
        anushiya.setEmployeeName("Anushiya");
        anushiya.setGender("female");
        anushiya.setNationality("Indian");
        anushiya.setMaritalStatus("single");
        List<String> languages = Arrays.asList("English", "Tamil", "Telugu");
        anushiya.setLanguage(languages);
        // anushiya.setLanguage(["English","Tamil","Telugu"]);
        // anushiya.setDateOfBirth("1999-05-25");
        anushiya.setBloodGroup("A1B +ve");
        anushiya.setPersonalEmail("anushiyadhamu@gmail.com");
        anushiya.setPersonalPhone("9500934741");
        anushiya.setEmergencyPhone("9500934741");
        anushiya.setAddress("3/31,Middle Street,Idaiseval,Kovilpatti");

        pavithra = new PersonalInfo();
        pavithra.setEmployeeId("2");
        pavithra.setEmployeeName("Pavithra");
        pavithra.setGender("female");
        pavithra.setNationality("Indian");
        pavithra.setMaritalStatus("single");
        List<String> language = Arrays.asList("English", "Tamil");
        anushiya.setLanguage(language);
        // pavithra.setLanguage(["English","Tamil"]);
        // pavithra.setDateOfBirth("1995-05-20");
        pavithra.setBloodGroup("o +");
        pavithra.setPersonalEmail("pavipavi491@gmail.com");
        pavithra.setPersonalPhone("9944822686");
        pavithra.setEmergencyPhone("9944822686");
        pavithra.setAddress("No-8-Sankaralingapuram, 1st-East Street, Kovilpatti");

    }

    @Test
    void createPersonalInfo() {
        when(personalInfoRepo.save(any(PersonalInfo.class))).thenReturn(anushiya);

        PersonalInfo personalInfo = personalInfoServiceimpl.createPersonalInfo(anushiya);

        assertNotNull(personalInfo);
        assertThat(personalInfo.getEmployeeId()).isEqualTo("1");
    }

    @Test
    void getPersonalInfo() {
        List<PersonalInfo> personalInfo = new ArrayList<>();
        personalInfo.add(anushiya);
        personalInfo.add(pavithra);

        when(personalInfoRepo.findAll()).thenReturn(personalInfo);

        List<PersonalInfo> personalInfoList = personalInfoServiceimpl.getPersonalInfo();

        assertEquals(2, personalInfoList.size());
        assertNotNull(personalInfoList);
    }

    @Test
    void getPersonalInfoById() {
        when(personalInfoRepo.findById(anyString())).thenReturn(Optional.of(anushiya));
        
        PersonalInfo personalInfo = personalInfoServiceimpl.getPersonalInfoById(anushiya.getEmployeeId());

        assertNotNull(personalInfo);
        assertThat(personalInfo.getEmployeeId()).isEqualTo("1");
    }

    @Test
    void updatePersonalInfo() {
        when(personalInfoRepo.findById(anyString())).thenReturn(Optional.of(anushiya));

        when(personalInfoRepo.save(any(PersonalInfo.class))).thenReturn(anushiya);
        anushiya.setPersonalEmail("anushiya@gmail.com");
        PersonalInfo existingInfo = personalInfoServiceimpl.updatePersonalInfo(anushiya.getEmployeeId(), anushiya);

        assertNotNull(existingInfo);
        assertEquals("anushiya@gmail.com", anushiya.getPersonalEmail());

    }

}
