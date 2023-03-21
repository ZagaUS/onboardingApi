package com.zaga.employeemangement.service;

import org.springframework.stereotype.Service;

import com.zaga.employeemangement.entity.EmployeeInfo;

@Service
public interface EmployeeBoardingService {

   public String createEmployee(EmployeeInfo employeeInfo);

   public String removeEmployee(String employeeId);

}
