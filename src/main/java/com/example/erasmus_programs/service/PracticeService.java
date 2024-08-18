package com.example.erasmus_programs.service;

import com.example.erasmus_programs.entity.Practice;
import com.example.erasmus_programs.entity.Training;
import com.example.erasmus_programs.exception.NotFoundException;
import com.example.erasmus_programs.repository.PracticeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PracticeService {
    private final PracticeRepository practiceRepository;

    public Practice getPracticeById(Long id) {
        return practiceRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Practice with Id not found " + id));
    }

    public List<Practice> getAllPractices() {
        return practiceRepository.findAll();
    }

    public Practice createPractice(Practice practice) {
        return this.practiceRepository.save(practice);
    }

    public Practice updatePractice(Practice practice) {
        Practice existing = practiceRepository
                .findById(practice.getId())
                .orElseThrow(() ->
                        new NotFoundException("Practice with Id now found " + practice.getId()));

        existing.setDescription(practice.getDescription());
        existing.setDoctoralMobility(practice.getDoctoralMobility());
        existing.setStudentMobility(practice.getStudentMobility());
        existing.setTeacherMobility(practice.getTeacherMobility());
        return this.practiceRepository.save(practice);
    }

    public void deletePracticeById(Long id) {
        practiceRepository.deleteById(practiceRepository
                .findById(id)
                .orElseThrow(() ->
                        new NotFoundException("Practice with Id now found " + id)).getId());
    }
}
