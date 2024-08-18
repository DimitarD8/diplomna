package com.example.erasmus_programs.service;

import com.example.erasmus_programs.entity.DoctoralMobility;
import com.example.erasmus_programs.entity.TeacherMobility;
import com.example.erasmus_programs.exception.NotFoundException;
import com.example.erasmus_programs.repository.TeacherMobilityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TeacherMobilityService {
    private final TeacherMobilityRepository teacherMobilityRepository;

    public List<TeacherMobility> getAllTeacherMobilities(){
        return teacherMobilityRepository.findAll();
    }

    public TeacherMobility getTeacherMobilityById(Long id){
        return teacherMobilityRepository
                .findById(id).orElseThrow(() ->
                        new NotFoundException("Teacher Mobility with id not found! " + id));
    }

    public TeacherMobility createTeacherMobility(TeacherMobility teacherMobility) {
        return this.teacherMobilityRepository.save(teacherMobility);
    }

    public TeacherMobility updateTeacherMobility(TeacherMobility teacherMobility) {
        TeacherMobility existing = teacherMobilityRepository
                .findById(teacherMobility.getId())
                .orElseThrow(() ->
                        new NotFoundException("Teacher Mobility with Id now found " + teacherMobility.getId()));

        existing.setDescription(teacherMobility.getDescription());
        return this.teacherMobilityRepository.save(teacherMobility);
    }

    public void deleteTeacherMobilityById(Long id) {
        teacherMobilityRepository.deleteById(teacherMobilityRepository
                .findById(id)
                .orElseThrow(() ->
                        new NotFoundException("Teacher Mobility with Id now found " + id)).getId());
    }
}
