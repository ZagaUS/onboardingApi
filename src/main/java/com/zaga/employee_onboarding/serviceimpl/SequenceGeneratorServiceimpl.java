package com.zaga.employee_onboarding.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaga.employee_onboarding.entity.SequenceGenerator;
import com.zaga.employee_onboarding.repository.SequenceGeneratorRepo;
import com.zaga.employee_onboarding.service.SequenceGeneratorService;

@Service
public class SequenceGeneratorServiceimpl implements SequenceGeneratorService {
    
    @Autowired
    SequenceGeneratorRepo sequenceGeneratorRepo;

    @Override
    public Integer sequenceGenerator() {
        SequenceGenerator sequence = sequenceGeneratorRepo.getSequence("employee");
        Integer seqNum = sequence.getSeqNum();
        Integer newSeqNo = seqNum + 1;
        sequence.setSeqNum(newSeqNo);
        sequenceGeneratorRepo.updatePersonalInfoByEmployeeId("employee", sequence);
        return newSeqNo;
    }
}
