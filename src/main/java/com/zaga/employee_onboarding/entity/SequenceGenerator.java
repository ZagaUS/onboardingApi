package com.zaga.employee_onboarding.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "sequence")
public class SequenceGenerator {

    public String seqName;
    public Integer seqNum;

}
