package com.zaga.employee_onboarding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zaga.employee_onboarding.entity.DocumentCollection;
import com.zaga.employee_onboarding.service.DocumentCollectionService;

@RestController
// @RequestMapping("/documentCollection")
public class DocumentCollectionController {

    @Autowired
    DocumentCollectionService documentCollectionService;

    @RequestMapping(path = "/upload", 
    method = RequestMethod.POST, 
    consumes = {MediaType.MULTIPART_FORM_DATA_VALUE })

    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file, DocumentCollection documentCollection) {
        try {
            documentCollectionService.uploadFile(file);
            return ResponseEntity.ok("File uploaded successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file: " + e.getMessage());
        }
    }
    
}
