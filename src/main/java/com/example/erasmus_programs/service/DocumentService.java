package com.example.erasmus_programs.service;

import com.example.erasmus_programs.dto.document.DocumentRequestDto;
import com.example.erasmus_programs.entity.Document;
import com.example.erasmus_programs.exception.FileStorageException;
import com.example.erasmus_programs.exception.NotFoundException;
import com.example.erasmus_programs.repository.DocumentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

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

    public Document createDocument(Document document) {
        return documentRepository.save(document);
    }


    public Document getFile(String fileName) {
        return documentRepository.findByFileName(fileName)
                .orElseThrow(() -> new FileStorageException("File not found with name " + fileName));
    }

    public Document getDocumentById(Long documentId) {
        return documentRepository.findById(documentId).orElseThrow(() -> new NotFoundException("Document not found"));
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
