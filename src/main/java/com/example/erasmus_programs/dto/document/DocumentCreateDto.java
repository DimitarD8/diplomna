package com.example.erasmus_programs.dto.document;

import com.example.erasmus_programs.entity.Mobility;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Base64;

@Getter
@Setter
@NoArgsConstructor
public class DocumentCreateDto {
    private String fileName;
    private byte[] data;


    public void setData(String base64Data) {
        this.data = Base64.getDecoder().decode(base64Data);
    }
}
