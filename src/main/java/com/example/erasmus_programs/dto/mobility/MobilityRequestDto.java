package com.example.erasmus_programs.dto.mobility;

import com.example.erasmus_programs.dto.document.DocumentCreateDto;
import com.example.erasmus_programs.dto.document.DocumentRequestDto;
import com.example.erasmus_programs.entity.Document;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class MobilityRequestDto {

    private String description;

    private String userType;

    private String type;

    private Set<DocumentCreateDto> documents;
}
