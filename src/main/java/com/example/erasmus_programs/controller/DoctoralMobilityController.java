package com.example.erasmus_programs.controller;

import com.example.erasmus_programs.entity.DoctoralMobility;
import com.example.erasmus_programs.service.DoctoralMobilityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctoral")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class DoctoralMobilityController {
    private final DoctoralMobilityService doctoralMobilityService;

    @GetMapping("/{id}")
    public ResponseEntity<DoctoralMobility> getDoctoralMobilityById(@PathVariable Long id) {
        DoctoralMobility doctoralMobility = doctoralMobilityService.getDoctoralMobilityById(id);
        return new ResponseEntity<>(doctoralMobility, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DoctoralMobility> createPractice(@RequestBody DoctoralMobility doctoralMobility) {
        DoctoralMobility createdDoctoralMobility = doctoralMobilityService.createDoctoralMobility(doctoralMobility);
        return new ResponseEntity<>(createdDoctoralMobility, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctoralMobility> updatePractice(@PathVariable Long id, @RequestBody DoctoralMobility doctoralMobility) {
        doctoralMobility.setId(id);
        DoctoralMobility updatedDoctoralMobility = doctoralMobilityService.updateDoctoralMobility(doctoralMobility);
        return new ResponseEntity<>(updatedDoctoralMobility, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePracticeById(@PathVariable Long id) {
        doctoralMobilityService.deleteDoctoralMobilityById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<DoctoralMobility>> getAllDoctoralMobilities() {
        List<DoctoralMobility> doctoralMobilities = doctoralMobilityService.getAllDoctoralMobilities();
        return new ResponseEntity<>(doctoralMobilities, HttpStatus.OK);
    }
}
