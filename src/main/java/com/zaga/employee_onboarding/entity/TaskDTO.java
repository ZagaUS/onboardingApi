package com.zaga.employee_onboarding.entity;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TaskDTO {

    @Id
    public String taskId;
    public String taskName;
    public String description;
    public Status status;
    
}
