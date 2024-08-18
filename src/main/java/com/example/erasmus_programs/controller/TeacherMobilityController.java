package com.example.erasmus_programs.controller;

import com.example.erasmus_programs.entity.TeacherMobility;
import com.example.erasmus_programs.service.TeacherMobilityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class TeacherMobilityController {

    private final TeacherMobilityService teacherMobilityService;

    @GetMapping
    public ResponseEntity<List<TeacherMobility>> getAllTeacherMobilities() {
        List<TeacherMobility> teacherMobilities = teacherMobilityService.getAllTeacherMobilities();
        return new ResponseEntity<>(teacherMobilities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherMobility> getTeacherMobilityById(@PathVariable Long id) {
        TeacherMobility teacherMobility = teacherMobilityService.getTeacherMobilityById(id);
        return new ResponseEntity<>(teacherMobility, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TeacherMobility> createTeacherMobility(@RequestBody TeacherMobility teacherMobility) {
        TeacherMobility createdTeacherMobility = teacherMobilityService.createTeacherMobility(teacherMobility);
        return new ResponseEntity<>(createdTeacherMobility, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeacherMobility> updateTeacherMobility(@PathVariable Long id, @RequestBody TeacherMobility teacherMobility) {
        teacherMobility.setId(id);
        TeacherMobility updatedTeacherMobility = teacherMobilityService.updateTeacherMobility(teacherMobility);
        return new ResponseEntity<>(updatedTeacherMobility, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacherMobilityById(@PathVariable Long id) {
        teacherMobilityService.deleteTeacherMobilityById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
