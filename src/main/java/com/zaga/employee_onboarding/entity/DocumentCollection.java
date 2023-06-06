package com.zaga.employee_onboarding.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"id"})
@Document(collection = "document")
public class DocumentCollection {

    public String employeeId;
    public String employeeName;
    public String fileName;
    // public String fileType;
    // public Long fileSize;
    public byte[] file;

}
