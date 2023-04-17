package com.zaga.employee_onboarding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zaga.employee_onboarding.entity.DayOff;
import com.zaga.employee_onboarding.service.DayOffService;


@RestController
public class DayOffController {
    @Autowired
    DayOffService dayOffService;
    
    @PostMapping("/dayOff")
    public ResponseEntity<DayOff> createDayOff(@RequestBody DayOff dayOff) {
        DayOff createDayOff = dayOffService.createDayOff(dayOff);
        return ResponseEntity.ok(createDayOff);
    }

    @GetMapping("/getAllDayOff")
    public ResponseEntity<List<DayOff>> getDayOff() {
        try {
            List<DayOff> getAllDayOff = dayOffService.getDayOff();
            return ResponseEntity.ok(getAllDayOff);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        
    }

    @GetMapping("/getDayOffById/{employeeId}")
    public ResponseEntity<DayOff> getDayOffById(@RequestParam String employeeId) {
        try {
            DayOff getDayOffById = dayOffService.getDayOffById(employeeId);
            return ResponseEntity.ok(getDayOffById);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/updateDayOff/{employeeId}")
    public ResponseEntity<DayOff> updateDayOff(@PathVariable String employeeId, @RequestBody DayOff dayOff) {
        try {
            DayOff updateDayOff = dayOffService.updateDayOff(employeeId, dayOff);
            return ResponseEntity.ok(updateDayOff);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}