package com.example.erasmus_programs.service;

import com.example.erasmus_programs.entity.DoctoralMobility;
import com.example.erasmus_programs.entity.StudentMobility;
import com.example.erasmus_programs.exception.NotFoundException;
import com.example.erasmus_programs.repository.StudentMobilityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentMobilityService {

    private final StudentMobilityRepository studentMobilityRepository;


    public List<StudentMobility> getAllStudentMobilities() {
        return studentMobilityRepository.findAll();
    }

    public StudentMobility getStudentMobilityById(Long id){
        return studentMobilityRepository
                .findById(id).orElseThrow(() ->
                        new NotFoundException("Student Mobility with id not found! " + id));
    }

    public StudentMobility createStudentMobility(StudentMobility studentMobility) {
        return this.studentMobilityRepository.save(studentMobility);
    }

    public StudentMobility updateStudentMobility(StudentMobility studentMobility) {
        StudentMobility existing = studentMobilityRepository
                .findById(studentMobility.getId())
                .orElseThrow(() ->
                        new NotFoundException("Student Mobility with Id now found " + studentMobility.getId()));

        existing.setPractice(studentMobility.getPractice());
        existing.setTraining(studentMobility.getTraining());
        return this.studentMobilityRepository.save(studentMobility);
    }

    public void deleteStudentMobilityById(Long id) {
        studentMobilityRepository.deleteById(studentMobilityRepository
                .findById(id)
                .orElseThrow(() ->
                        new NotFoundException("Student Mobility with Id now found " + id)).getId());
    }
}
