package com.example.erasmus_programs.controller;

import com.example.erasmus_programs.entity.StudentMobility;
import com.example.erasmus_programs.service.StudentMobilityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class StudentMobilityController {

    private final StudentMobilityService studentMobilityService;

    @GetMapping("/{id}")
    public ResponseEntity<StudentMobility> getStudentMobilityById(@PathVariable Long id) {
        StudentMobility studentMobility = studentMobilityService.getStudentMobilityById(id);
        return new ResponseEntity<>(studentMobility, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudentMobility> createPractice(@RequestBody StudentMobility studentMobility) {
        StudentMobility createdStudentMobility = studentMobilityService.createStudentMobility(studentMobility);
        return new ResponseEntity<>(createdStudentMobility, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentMobility> updatePractice(@PathVariable Long id, @RequestBody StudentMobility studentMobility) {
        studentMobility.setId(id);
        StudentMobility updatedStudentMobility = studentMobilityService.updateStudentMobility(studentMobility);
        return new ResponseEntity<>(updatedStudentMobility, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePracticeById(@PathVariable Long id) {
        studentMobilityService.deleteStudentMobilityById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<StudentMobility>> getAllStudentMobilities() {
        List<StudentMobility> studentMobilities = studentMobilityService.getAllStudentMobilities();
        return new ResponseEntity<>(studentMobilities, HttpStatus.OK);
    }
}
