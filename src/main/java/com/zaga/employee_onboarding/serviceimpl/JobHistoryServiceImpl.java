package com.zaga.employee_onboarding.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaga.employee_onboarding.entity.JobHistory;
import com.zaga.employee_onboarding.repository.JobHistoryRepo;
import com.zaga.employee_onboarding.service.JobHistoryService;

@Service
public class JobHistoryServiceImpl implements JobHistoryService {

    @Autowired
    JobHistoryRepo repo;

    @Override
    public JobHistory createJobHistoryInfo(JobHistory dto) {
        JobHistory info = repo.save(dto);
        return info;
    }

    @Override
    public List<JobHistory> getJobHistorynfo() {
        List<JobHistory> getJobhistoryInfo = repo.findAll();
        return getJobhistoryInfo;
    }

    @Override
    public JobHistory getJobHistorynfoById(String employeeId) {
        JobHistory getInfo = repo.getJobHistoryDetails(employeeId);
        return getInfo;
    }

    @Override
    public JobHistory updateJobHistoryInfo(String employeeId, JobHistory dto) {
        JobHistory updateJobhistoryInfo = repo.getJobHistoryDetails(employeeId);
        dto.setId(updateJobhistoryInfo.getId());

        return repo.save(dto);

    }

}
