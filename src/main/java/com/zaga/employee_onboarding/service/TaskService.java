package com.zaga.employee_onboarding.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zaga.employee_onboarding.entity.Task;

@Service
public interface TaskService {
    public Task createTask(Task task);

    public List<Task> getTask();

    public Task getTaskById(String employeeId);

    public Task updateTask(String employeeId,Task task);


    
}
