package com.zaga.employee_onboarding.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"id"})
@Document(collection = "Task")

public class Task {
    
   
    @Id
    public ObjectId id;
    public String taskId;
    public String taskName;
    public String description;
    public Status status; 
}
