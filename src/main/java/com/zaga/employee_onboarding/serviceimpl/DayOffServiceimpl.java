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
        DayOff dayoff = dayOffRepo.save(dayOff);
        return dayoff;
        
    }

    @Override
    public List<DayOff> getDayOff() {
        List<DayOff> getDayOff = dayOffRepo.findAll();
        return getDayOff;
        
    }

    @Override
    public DayOff getDayOffById(String employeeId) {
        DayOff dayOff = dayOffRepo.findById(employeeId).orElse(null);
        return dayOff;
    }


    @Override
    public DayOff updateDayOff(String employeeId, DayOff dayOff) {

        DayOff dd = dayOffRepo.findById(employeeId).orElse(null);
        if (dd == null) {
            throw new RuntimeException("DayOff not found with id " + employeeId);
        }

        else {
            DayOff dayoff = dd;
            dayoff.setId(dayOff.getId());
            dayoff.setAllocatedLeave(dayOff.getAllocatedLeave());
            dayoff.setBalance(dayOff.getBalance());
            dayoff.setUsed(dayOff.getUsed());
            return dayOffRepo.save(dayoff);
        }
    //     // Optional<DayOff> dayOffData = dayOffRepo.findById(employeeId);
    //     // DayOff existingDayOff = dayOffData.get();
    //     // existingDayOff.setAllocatedLeave(dayOff.getAllocatedLeave());
    //     // existingDayOff.setBalance(dayOff.getBalance());
    //     // existingDayOff.setUsed(dayOff.getUsed());
    //     // DayOff updatedDayOff = dayOffRepo.save(existingDayOff);
    //     // return updatedDayOff;

    }
    
}
