package com.zaga.employee_onboarding.serviceimpl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.zaga.employee_onboarding.entity.DocumentCollection;
import com.zaga.employee_onboarding.repository.DocumentCollectionRepo;
import com.zaga.employee_onboarding.service.DocumentCollectionService;

@Service
public class DocumentCollectionServiceimpl implements DocumentCollectionService {

    @Autowired
    DocumentCollectionRepo documentCollectionRepo;
    
    @Override
    public String uploadFile(MultipartFile file) throws IOException {
        if (file.getSize() > 16 * 1024 * 1024) {
            throw new IllegalArgumentException("File size exceeds maximum allowed limit of 16MB.");
        }

        String fileName = file.getOriginalFilename();
        DocumentCollection documentCollection = new DocumentCollection();
        documentCollection.setFileName(file.getOriginalFilename());
        documentCollection.setFileContent(file.getBytes());
        documentCollectionRepo.save(documentCollection);
        return fileName;
    }
}
