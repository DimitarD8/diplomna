package com.example.erasmus_programs.controller;


import com.example.erasmus_programs.entity.Practice;
import com.example.erasmus_programs.service.PracticeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/practice")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class PracticeController {

    private final PracticeService practiceService;

    @PostMapping
    public ResponseEntity<Practice> createPractice(@RequestBody Practice practice) {
        Practice createdPractice = practiceService.createPractice(practice);
        return new ResponseEntity<>(createdPractice, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Practice> updatePractice(@PathVariable Long id, @RequestBody Practice practice) {
        practice.setId(id);
        Practice updatedPractice = practiceService.updatePractice(practice);
        return new ResponseEntity<>(updatedPractice, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePracticeById(@PathVariable Long id) {
        practiceService.deletePracticeById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Practice> getPracticeById(@PathVariable Long id) {
        Practice practice = practiceService.getPracticeById(id);
        return new ResponseEntity<>(practice, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Practice>> getAllPractices() {
        List<Practice> practices = practiceService.getAllPractices();
        return new ResponseEntity<>(practices, HttpStatus.OK);
    }

}
