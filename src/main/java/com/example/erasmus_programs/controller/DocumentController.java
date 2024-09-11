package com.example.erasmus_programs.controller;

import com.example.erasmus_programs.dto.document.DocumentRequestDto;
import com.example.erasmus_programs.entity.Document;
import com.example.erasmus_programs.service.DocumentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/documents")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class DocumentController {
    private final DocumentService documentService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            Document pdfFile = documentService.storeFile(file);
            return ResponseEntity.ok("File uploaded successfully: " + pdfFile.getFileName());
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file");
        }
    }

    @GetMapping(path = "/download")
    public ResponseEntity<byte[]> downloadDocument(@RequestParam Long documentId) {
        Document document = documentService.getDocumentById(documentId);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + document.getFileName() + "\"")
                .contentType(MediaType.APPLICATION_PDF)
                .body(document.getData());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateFile(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        try {
            Document updatedFile = documentService.updateFile(id, file);
            return ResponseEntity.ok("File updated successfully: " + updatedFile.getFileName());
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update file");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDocumentById(@PathVariable Long id) {
        documentService.deleteDocumentById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
