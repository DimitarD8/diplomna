package com.example.erasmus_programs.service;

import com.example.erasmus_programs.entity.Document;
import com.example.erasmus_programs.exception.FileStorageException;
import com.example.erasmus_programs.exception.NotFoundException;
import com.example.erasmus_programs.repository.DocumentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@AllArgsConstructor
public class DocumentService {
    private final DocumentRepository documentRepository;

    public Document storeFile(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        Document pdfFile = new Document();
        pdfFile.setFileName(fileName);
        pdfFile.setData(file.getBytes());

        return documentRepository.save(pdfFile);
    }

    public Document getFile(String fileName) {
        return documentRepository.findByFileName(fileName)
                .orElseThrow(() -> new FileStorageException("File not found with name " + fileName));
    }

    public Document updateFile(Long id, MultipartFile newFile) throws IOException {
        Document existingFile = documentRepository.findById(id)
                .orElseThrow(() -> new FileStorageException("File not found with id " + id));

        existingFile.setFileName(StringUtils.cleanPath(newFile.getOriginalFilename()));
        existingFile.setData(newFile.getBytes());

        return documentRepository.save(existingFile);
    }

    public void deleteDocumentById(Long id) {
        documentRepository.deleteById(documentRepository
                .findById(id)
                .orElseThrow(() ->
                        new NotFoundException("Document with Id now found " + id)).getId());
    }
}
