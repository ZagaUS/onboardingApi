package com.zaga.employee_onboarding.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zaga.employee_onboarding.entity.DayOff;

@Service
public interface DayOffService {
    public DayOff createDayOff(DayOff dayOff);

    public List<DayOff> getDayOff();

    public DayOff getDayOffById(String employeeId);

    public DayOff updateDayOff(String employeeId, DayOff dayOff);
    
}
