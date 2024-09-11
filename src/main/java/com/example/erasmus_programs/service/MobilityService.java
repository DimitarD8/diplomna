package com.example.erasmus_programs.service;

import com.example.erasmus_programs.dto.mobility.MobilityRequestDto;
import com.example.erasmus_programs.dto.mobility.MobilityResponseDto;
import com.example.erasmus_programs.dto.mobility.MobilityUpdateDto;
import com.example.erasmus_programs.entity.Document;
import com.example.erasmus_programs.entity.Mobility;
import com.example.erasmus_programs.exception.NotFoundException;
import com.example.erasmus_programs.mapper.document.DocumentMapper;
import com.example.erasmus_programs.mapper.mobility.MobilityMapper;
import com.example.erasmus_programs.repository.MobilityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MobilityService {

    private final MobilityRepository mobilityRepository;

    @Transactional(readOnly = true)
    public List<Mobility> findAll() {
        return mobilityRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<MobilityResponseDto> findAllDoctoralTrainingMobilities() {
        return mobilityRepository.findAll().stream().filter(mobility ->
                mobility.getType().equals("TRAINING") && mobility.getUserType().equals("DOCTORAL")
        ).map(MobilityMapper::mapToResponse).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MobilityResponseDto> findAllDoctoralPracticeMobilities() {
        return mobilityRepository.findAll().stream().filter(mobility ->
                mobility.getType().equals("PRACTICE") && mobility.getUserType().equals("DOCTORAL")
        ).map(MobilityMapper::mapToResponse).collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public List<MobilityResponseDto> findAllDoctoralIntensiveShortTermTrainingMobilities() {
        return mobilityRepository.findAll().stream().filter(mobility ->
                mobility.getType().equals("INTENSIVESHORTTERMTRAINING") && mobility.getUserType().equals("DOCTORAL")
        ).map(MobilityMapper::mapToResponse).collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public List<MobilityResponseDto> findAllStudentTrainingMobilities() {
        return mobilityRepository.findAll().stream().filter(mobility ->
                mobility.getType().equals("TRAINING") && mobility.getUserType().equals("STUDENT")
        ).map(MobilityMapper::mapToResponse).collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public List<MobilityResponseDto> findAllStudentPracticeMobilities() {
        return mobilityRepository.findAll().stream().filter(mobility ->
                mobility.getType().equals("PRACTICE") && mobility.getUserType().equals("STUDENT")
        ).map(MobilityMapper::mapToResponse).collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public List<MobilityResponseDto> findAllTeacherPracticeMobilities() {
        return mobilityRepository.findAll().stream().filter(mobility ->
                mobility.getType().equals("PRACTICE") && mobility.getUserType().equals("TEACHER")
        ).map(MobilityMapper::mapToResponse).collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public List<MobilityResponseDto> findAllTeacherTrainingMobilities() {
        return mobilityRepository.findAll().stream().filter(mobility ->
                mobility.getType().equals("TRAINING") && mobility.getUserType().equals("TEACHER")
        ).map(MobilityMapper::mapToResponse).collect(Collectors.toList());
    }

    public Mobility findById(Long id) {
        return mobilityRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Mobility with Id not found! " + id));
    }

    public Mobility save(MobilityRequestDto mobilityRequestDto) {
        return mobilityRepository.save(MobilityMapper.mapToMobility(mobilityRequestDto));
    }

    @Transactional
    public Mobility update(MobilityUpdateDto mobilityDetails) {
        Mobility existing = mobilityRepository.findById(mobilityDetails.getId())
                .orElseThrow(() -> new NotFoundException("Mobility with Id not found! " + mobilityDetails.getId()));

        existing.setDescription(mobilityDetails.getDescription());
        existing.setUserType(mobilityDetails.getUserType());
        existing.setType(mobilityDetails.getType());

        existing.getDocuments().clear();
        if (mobilityDetails.getDocuments() != null) {
            mobilityDetails.getDocuments().forEach(documentUpdateDto -> {
                Document document = DocumentMapper.mapToDocumentUpdate(documentUpdateDto);
                existing.addDocument(document);
            });
        }

        return mobilityRepository.save(existing);
    }

    public void deleteById(Long id) {
        mobilityRepository.deleteById(id);
    }
}
