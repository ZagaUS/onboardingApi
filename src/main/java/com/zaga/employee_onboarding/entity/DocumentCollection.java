package com.zaga.employee_onboarding.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "document")
public class DocumentCollection {

    public String fileName;
    public byte[] file;

}
