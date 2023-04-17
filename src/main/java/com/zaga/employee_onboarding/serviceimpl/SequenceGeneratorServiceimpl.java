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
    public long getNextSequence(String seqName) {
    SequenceGenerator sequenceGenerator = sequenceGeneratorRepo.findById(seqName).orElse(null);
        if (sequenceGenerator == null) {
            sequenceGenerator = new SequenceGenerator();
            sequenceGenerator.setSeqName(seqName);
            sequenceGenerator.setSeqNum(1);
            // sequenceGeneratorRepo.save(sequenceGenerator);
            try {
                sequenceGeneratorRepo.save(sequenceGenerator);
            } catch (Exception e) {
                System.out.println("Exception during save: " + e.getMessage());
            }
        }

        int nextValue = sequenceGenerator.getSeqNum();
        sequenceGenerator.setSeqNum(nextValue + 1);
        // sequenceGeneratorRepo.save(sequenceGenerator);
        try {
            sequenceGeneratorRepo.save(sequenceGenerator);
        } catch (Exception e) {
            System.out.println("Exception during save: " + e.getMessage());
        }

        return nextValue;

    }

}
