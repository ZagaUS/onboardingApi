package com.zaga.employee_onboarding.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaga.employee_onboarding.entity.Task;
import com.zaga.employee_onboarding.repository.TaskRepo;
import com.zaga.employee_onboarding.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    TaskRepo taskRepo;

    

    @Override
    public List<Task> getTask() {
        List<Task> getTasks=taskRepo.findAll();
        return getTasks;
           }

    @Override
    public Task getTaskById(String employeeId) {
        Task getTask=taskRepo.findById(employeeId).orElse(null);
        return getTask;
    }

    @Override
    public Task updateTask(String employeeId, Task task) {

        Task updateTask=taskRepo.findById(employeeId).get();
        updateTask.setTaskId(task.getTaskId());
        updateTask.setTaskName(task.getTaskName());
        updateTask.setDescription(task.getDescription());
        updateTask.setStatus(task.getStatus());
        return taskRepo.save(updateTask);

    }

    @Override
    public Task createTask(Task task) {
        Task task2 = taskRepo.save(task);
        return task2;
    }
    
}
