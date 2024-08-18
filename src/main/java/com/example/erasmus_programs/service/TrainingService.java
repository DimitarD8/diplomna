package com.example.erasmus_programs.service;

import com.example.erasmus_programs.entity.Training;
import com.example.erasmus_programs.exception.NotFoundException;
import com.example.erasmus_programs.repository.TrainingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TrainingService {
    private final TrainingRepository trainingRepository;

    public Training getTrainingById(Long id) {
        return trainingRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Training with Id not found " + id));
    }

    public List<Training> getAllTrainings() {
        return trainingRepository.findAll();
    }

    public Training createTraining(Training training) {
        return this.trainingRepository.save(training);
    }

    public Training updateTraining(Training training) {
        Training existing = trainingRepository
                .findById(training.getId())
                .orElseThrow(() ->
                        new NotFoundException("Training with Id now found " + training.getId()));

        existing.setDescription(training.getDescription());
        existing.setDoctoralMobility(training.getDoctoralMobility());
        existing.setStudentMobility(training.getStudentMobility());
        existing.setTeacherMobility(training.getTeacherMobility());
        return this.trainingRepository.save(training);
    }

    public void deleteTrainingById(Long id) {
        trainingRepository.deleteById(trainingRepository
                .findById(id)
                .orElseThrow(() ->
                        new NotFoundException("Training with Id now found " + id)).getId());
    }
}
