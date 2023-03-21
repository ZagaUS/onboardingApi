package com.zaga.employeemangement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zaga.employeemangement.entity.EmployeeInfo;
import com.zaga.employeemangement.service.EmployeeInfoService;

@RestController
@RequestMapping("/zagahrms")
public class EmployeeInfoController {

    @Autowired
    EmployeeInfoService employeeInfoService;

    @GetMapping
    public List<EmployeeInfo> getallEmployeeInfo(@RequestParam("employeeId") String employeeId) {
        return employeeInfoService.getemployeeInfo(employeeId);
    }

}
