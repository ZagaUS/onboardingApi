package com.zaga.employee_onboarding.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zaga.employee_onboarding.entity.JobHistory;

@Service
public interface JobHistoryService {
    JobHistory createJobHistoryInfo(JobHistory dto);

    List<JobHistory> getJobHistorynfo();

    JobHistory getJobHistorynfoById(String employeeId);

    JobHistory updateJobHistoryInfo(String employeeId, JobHistory dto);

    public void deleteJobHistoryInfo(String employeeId);
}
