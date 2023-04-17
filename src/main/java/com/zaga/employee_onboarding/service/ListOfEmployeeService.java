package com.zaga.employee_onboarding.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zaga.employee_onboarding.entity.ListOfEmployee;

@Service
public interface ListOfEmployeeService {
    
    public List<ListOfEmployee> getAllEmployees();
    
}
