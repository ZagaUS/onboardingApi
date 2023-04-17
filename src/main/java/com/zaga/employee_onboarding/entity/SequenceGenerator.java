package com.zaga.employee_onboarding.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "sequence")
public class SequenceGenerator {

    @Id
    public String seqName;
    public Integer seqNum;

}
