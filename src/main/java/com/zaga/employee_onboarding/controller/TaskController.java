package com.zaga.employee_onboarding.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zaga.employee_onboarding.entity.Task;
import com.zaga.employee_onboarding.repository.TaskRepo;
import com.zaga.employee_onboarding.service.TaskService;

// import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class TaskController {

    @Autowired
    TaskService taskService;

    @Autowired
    TaskRepo taskRepo;

    @PostMapping("/createTask")
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        Task createTask = taskService.createTask(task);
        return ResponseEntity.ok(createTask);

    }

    @GetMapping("/getAllTask")
    public ResponseEntity<List<Task>> getTask(){
        try {
            List<Task> getTasks = taskService.getTask();
            return ResponseEntity.ok(getTasks);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }

    @GetMapping("/getTaskById")
    public ResponseEntity<Task> getTaskByTaskId(String taskId){
        try {
            Task getTaskByTaskId = taskRepo.getTaskByTaskId(taskId);
            return ResponseEntity.ok(getTaskByTaskId);
        } catch (Exception e) {
           return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/updateTask")
    public ResponseEntity<Task> updateTask(@RequestBody Task task,@RequestParam String taskId){
        System.out.println(task);
        System.out.println("----------------------------------"+taskId);
        try {
            Task updateTask = taskService.updateTask(taskId, task);
            return ResponseEntity.ok(updateTask);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
}
