package com.example.erasmus_programs.controller;

import com.example.erasmus_programs.dto.mobility.MobilityRequestDto;
import com.example.erasmus_programs.dto.mobility.MobilityResponseDto;
import com.example.erasmus_programs.dto.mobility.MobilityUpdateDto;
import com.example.erasmus_programs.entity.Mobility;
import com.example.erasmus_programs.service.MobilityService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mobility")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class MobilityController {

    private final MobilityService mobilityService;

    @GetMapping
    public ResponseEntity<List<Mobility>> getAllMobilities() {
        return ResponseEntity.ok(mobilityService.findAll());
    }

    @GetMapping("/doctoral/practice")
    public ResponseEntity<List<MobilityResponseDto>> getAllDoctoralPractices() {
        return ResponseEntity.ok(mobilityService.findAllDoctoralPracticeMobilities());
    }

    @GetMapping("/doctoral/training")
    public ResponseEntity<List<MobilityResponseDto>> getAllDoctoralTrainings() {
        return ResponseEntity.ok(mobilityService.findAllDoctoralTrainingMobilities());
    }

    @GetMapping("/doctoral/intensive-short")
    public ResponseEntity<List<MobilityResponseDto>> getAllDoctoralIntensiveShortTermTrainings() {
        return ResponseEntity.ok(mobilityService.findAllDoctoralIntensiveShortTermTrainingMobilities());
    }

    @GetMapping("/student/training")
    public ResponseEntity<List<MobilityResponseDto>> getAllStudentTrainings() {
        return ResponseEntity.ok(mobilityService.findAllStudentTrainingMobilities());
    }

    @GetMapping("/student/practice")
    public ResponseEntity<List<MobilityResponseDto>> getAllStudentPractices() {
        return ResponseEntity.ok(mobilityService.findAllStudentPracticeMobilities());
    }

    @GetMapping("/teacher/practice")
    public ResponseEntity<List<MobilityResponseDto>> getAllTeacherPractices() {
        return ResponseEntity.ok(mobilityService.findAllTeacherPracticeMobilities());
    }

    @GetMapping("/teacher/training")
    public ResponseEntity<List<MobilityResponseDto>> getAllTeacherTrainings() {
        return ResponseEntity.ok(mobilityService.findAllTeacherTrainingMobilities());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mobility> getMobilityById(@PathVariable Long id) {
        return ResponseEntity.ok(mobilityService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Mobility> createMobility(@RequestBody MobilityRequestDto mobility) {
        return ResponseEntity.ok(mobilityService.save(mobility));
    }

    @PutMapping()
    public ResponseEntity<Mobility> updateMobility(@RequestBody MobilityUpdateDto mobilityDetails) {
        return ResponseEntity.ok(mobilityService.update(mobilityDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMobility(@PathVariable Long id) {
        mobilityService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
