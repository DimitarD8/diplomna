package com.example.erasmus_programs.dto.document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DocumentUpdateDto {
    private Long id;
    private String fileName;
    private byte[] data;

}
