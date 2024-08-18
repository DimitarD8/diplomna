package com.example.erasmus_programs.controller;

import com.example.erasmus_programs.entity.IntensiveShortTermTraining;
import com.example.erasmus_programs.service.IntensiveShortTermTrainingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/intensive-training")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class IntensiveShortTermTrainingController {

    private final IntensiveShortTermTrainingService intensiveShortTermTrainingService;

    @GetMapping
    public ResponseEntity<List<IntensiveShortTermTraining>> getAllTrainings() {
        List<IntensiveShortTermTraining> trainings = intensiveShortTermTrainingService.getAllTrainings();
        return new ResponseEntity<>(trainings, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IntensiveShortTermTraining> getTrainingById(@PathVariable Long id) {
        IntensiveShortTermTraining training = intensiveShortTermTrainingService.getTrainingById(id);
        return new ResponseEntity<>(training, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<IntensiveShortTermTraining> createTraining(@RequestBody IntensiveShortTermTraining training) {
        IntensiveShortTermTraining createdTraining = intensiveShortTermTrainingService.createTraining(training);
        return new ResponseEntity<>(createdTraining, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IntensiveShortTermTraining> updateTraining(@PathVariable Long id, @RequestBody IntensiveShortTermTraining training) {
        IntensiveShortTermTraining updatedTraining = intensiveShortTermTrainingService.updateTraining(id, training);
        return new ResponseEntity<>(updatedTraining, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrainingById(@PathVariable Long id) {
        intensiveShortTermTrainingService.deleteTrainingById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
