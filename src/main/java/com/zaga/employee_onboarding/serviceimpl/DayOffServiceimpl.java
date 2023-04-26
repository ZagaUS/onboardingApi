package com.zaga.employee_onboarding.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaga.employee_onboarding.entity.DayOff;
import com.zaga.employee_onboarding.repository.DayOffRepo;
import com.zaga.employee_onboarding.service.DayOffService;

@Service
public class DayOffServiceimpl implements DayOffService {
    
    @Autowired
    DayOffRepo dayOffRepo;

    @Override
    public DayOff createDayOff(DayOff dayOff) {
        DayOff dayoff2 = dayOffRepo.save(dayOff);
        return dayoff2;
        
    }

    @Override
    public List<DayOff> getDayOff() {
        List<DayOff> getDayOff = dayOffRepo.findAll();
        return getDayOff;
        
    }

    @Override
    public DayOff getDayOffById(String employeeId) {
        DayOff getDayoff = dayOffRepo.findById(employeeId).orElse(null);
        return getDayoff;
    }

    @Override
    public DayOff updateDayOff(String employeeId, DayOff dayOff) {

        DayOff updateDayOff = dayOffRepo.findById(employeeId).get();
        updateDayOff.setAllocatedLeave(dayOff.getAllocatedLeave());
        updateDayOff.setUsed(dayOff.getUsed());
        updateDayOff.setBalance(dayOff.getBalance());
        return dayOffRepo.save(updateDayOff);

    }
    
}
