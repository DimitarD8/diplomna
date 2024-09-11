package com.example.erasmus_programs.dto.mobility;

import com.example.erasmus_programs.dto.document.DocumentCreateDto;
import com.example.erasmus_programs.dto.document.DocumentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class MobilityResponseDto {

    private Long id;

    private String description;

    private String userType;

    private String type;

    private Set<DocumentRequestDto> documents;
}
