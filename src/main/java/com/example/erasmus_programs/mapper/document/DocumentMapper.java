package com.example.erasmus_programs.mapper.document;


import com.example.erasmus_programs.dto.document.DocumentCreateDto;
import com.example.erasmus_programs.dto.document.DocumentRequestDto;
import com.example.erasmus_programs.dto.document.DocumentUpdateDto;
import com.example.erasmus_programs.entity.Document;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DocumentMapper {

    public static DocumentRequestDto mapToDto(Document document){
        DocumentRequestDto dto = new DocumentRequestDto();

        dto.setId(document.getId());
        dto.setFileName(document.getFileName());

        return dto;
    }

    public static Document mapToDocument(DocumentCreateDto dto) {
        Document document = new Document();
        document.setFileName(dto.getFileName());
        if (dto.getData() == null) {
            document.setData(new byte[256]);
        } else {
            document.setData(dto.getData());
        }
        return document;
    }

    public static Document mapToDocumentUpdate(DocumentUpdateDto dto) {
        Document document = new Document();
        document.setId(dto.getId());
        document.setFileName(dto.getFileName());
        if (dto.getData() == null) {
            document.setData(new byte[256]);
        } else {
            document.setData(dto.getData());
        }
        return document;
    }

}
