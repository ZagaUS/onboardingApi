package com.zaga.employee_onboarding.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaga.employee_onboarding.entity.ListOfEmployee;
import com.zaga.employee_onboarding.repository.ListOfEmployeeRepo;
import com.zaga.employee_onboarding.service.ListOfEmployeeService;

@Service
public class ListOfEmployeeServiceimpl implements ListOfEmployeeService {
    
    @Autowired
    ListOfEmployeeRepo listOfEmployeeRepo;

    @Override
    public List<ListOfEmployee> getAllEmployees() {
        List<ListOfEmployee> getEmployeeInfo = listOfEmployeeRepo.findAll();
        return getEmployeeInfo;
    }

    
}
