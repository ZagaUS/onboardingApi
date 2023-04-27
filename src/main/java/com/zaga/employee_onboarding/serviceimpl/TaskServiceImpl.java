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
    public Task getTaskById(String taskId){ 
        System.out.println("______________________taskID"+taskId);
        Task getTaskById=taskRepo.findById(taskId).get();
        System.out.println("*****************************data********"+getTaskById);
        return getTaskById;
    }

    @Override
    public Task updateTask(String taskId, Task task) {

        Task updateTask = taskRepo.getTaskByTaskId(taskId);
        System.out.println(updateTask);
        System.out.println("--------------------------------------");
        task.setId(updateTask.getId());
        return taskRepo.save(task);

    }

    @Override
    public Task createTask(Task task) {
        Task task2 = taskRepo.save(task);
        return task2;
    }
    
}
