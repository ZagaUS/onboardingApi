package com.zaga.employee_onboarding.service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface DocumentCollectionService {
    
    public String uploadFile(MultipartFile file) throws IOException;
    
}
