package com.example.erasmus_programs.service;

import com.example.erasmus_programs.entity.IntensiveShortTermTraining;
import com.example.erasmus_programs.exception.NotFoundException;
import com.example.erasmus_programs.repository.IntensiveShortTermTrainingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class IntensiveShortTermTrainingService {

    private final IntensiveShortTermTrainingRepository intensiveShortTermTrainingRepository;

    public List<IntensiveShortTermTraining> getAllTrainings() {
        return intensiveShortTermTrainingRepository.findAll();
    }

    public IntensiveShortTermTraining getTrainingById(Long id) {
        return intensiveShortTermTrainingRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Training with id " + id + " not found"));
    }

    public IntensiveShortTermTraining createTraining(IntensiveShortTermTraining training) {
        return intensiveShortTermTrainingRepository.save(training);
    }

    public IntensiveShortTermTraining updateTraining(Long id, IntensiveShortTermTraining training) {
        IntensiveShortTermTraining existing = intensiveShortTermTrainingRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Training with id " + id + " not found"));

        existing.setDescription(training.getDescription());
        // Update other fields as necessary

        return intensiveShortTermTrainingRepository.save(existing);
    }

    public void deleteTrainingById(Long id) {
        IntensiveShortTermTraining existing = intensiveShortTermTrainingRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Training with id " + id + " not found"));

        intensiveShortTermTrainingRepository.deleteById(existing.getId());
    }
}
