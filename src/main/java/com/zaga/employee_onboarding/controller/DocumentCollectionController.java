package com.zaga.employee_onboarding.controller;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zaga.employee_onboarding.entity.DocumentCollection;
import com.zaga.employee_onboarding.entity.MetaData;
import com.zaga.employee_onboarding.repository.DocumentCollectionRepo;

@RestController
public class DocumentCollectionController {

    @Autowired
    DocumentCollectionRepo repo;

    @PostMapping(path = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DocumentCollection> uploadPDF(@RequestPart("file") MultipartFile file,
            @RequestPart("metadata") String metadataJson) throws IOException {
        // if (file.getSize() > 10 * 1024 * 1024) {
        // return ResponseEntity.badRequest().body(null);
        // }

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            MetaData metadata = objectMapper.readValue(metadataJson, MetaData.class);

            DocumentCollection pdf = new DocumentCollection();
            pdf.setFileName(file.getOriginalFilename());
            pdf.setFile(file.getBytes());
            // pdf.setFileType(file.getContentType());
            // pdf.setFileSize(file.getSize());
            pdf.setEmployeeId(metadata.getEmployeeId());
            pdf.setEmployeeName(metadata.getEmployeeName());
            DocumentCollection savedPDF = repo.save(pdf);

            return ResponseEntity.ok(savedPDF);
        } catch (IOException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/pdf/{employeeId}")
    public ResponseEntity<String> downloadPDF(@PathVariable String employeeId) {
        System.out.println("employeeId: " + employeeId);

        DocumentCollection pdf = repo.findByEmployeeId(employeeId, DocumentCollection.class);
        if (pdf == null) {
            return ResponseEntity.notFound().build();
        }
        if (pdf.getFile().length > 10 * 1024 * 1024) {
            return ResponseEntity.badRequest().body("File size exceeds 10MB.");
        }

        String base64String = Base64.getEncoder().encodeToString(pdf.getFile());

        // HttpHeaders headers = new HttpHeaders();
        // headers.setContentType(MediaType.APPLICATION_PDF);
        // headers.setContentDisposition(ContentDisposition.builder("inline").filename(pdf.getFileName()).build());

        return ResponseEntity.ok().body(base64String);
    }

}
