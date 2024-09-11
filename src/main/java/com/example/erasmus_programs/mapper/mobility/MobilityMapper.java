package com.example.erasmus_programs.mapper.mobility;

import com.example.erasmus_programs.dto.mobility.MobilityRequestDto;
import com.example.erasmus_programs.dto.mobility.MobilityResponseDto;
import com.example.erasmus_programs.dto.mobility.MobilityUpdateDto;
import com.example.erasmus_programs.entity.Document;
import com.example.erasmus_programs.entity.Mobility;
import com.example.erasmus_programs.mapper.document.DocumentMapper;

import java.util.stream.Collectors;

public class MobilityMapper {

    public static Mobility mapToMobility(MobilityRequestDto requestDto) {
        Mobility mobility = new Mobility();
        mobility.setDescription(requestDto.getDescription());
        mobility.setUserType(requestDto.getUserType());
        mobility.setType(requestDto.getType());

        if (requestDto.getDocuments() != null) {
            requestDto.getDocuments().forEach(documentCreateDto -> {
                Document document = DocumentMapper.mapToDocument(documentCreateDto);
                mobility.addDocument(document);
            });
        }
        return mobility;
    }

    public static MobilityResponseDto mapToResponse(Mobility mobility) {
        MobilityResponseDto responseDto = new MobilityResponseDto();
        responseDto.setId(mobility.getId());
        responseDto.setDescription(mobility.getDescription());
        responseDto.setUserType(mobility.getUserType());
        responseDto.setType(mobility.getType());
        responseDto.setDocuments(mobility.getDocuments().stream().map(DocumentMapper::mapToDto).collect(Collectors.toSet()));

        return responseDto;
    }

    public static Mobility mapToMobilityUpdate(MobilityUpdateDto updateDto){
        Mobility mobility = new Mobility();
        mobility.setId(updateDto.getId());
        mobility.setDescription(updateDto.getDescription());
        mobility.setUserType(updateDto.getUserType());
        mobility.setType(updateDto.getType());

        if (updateDto.getDocuments() != null) {
            updateDto.getDocuments().forEach(documentUpdateDto -> {
                Document document = DocumentMapper.mapToDocumentUpdate(documentUpdateDto);
                mobility.addDocument(document);
            });
        }
        return mobility;
    }
}
