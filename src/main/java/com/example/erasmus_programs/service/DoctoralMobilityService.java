package com.example.erasmus_programs.service;

import com.example.erasmus_programs.entity.DoctoralMobility;
import com.example.erasmus_programs.entity.Practice;
import com.example.erasmus_programs.exception.NotFoundException;
import com.example.erasmus_programs.repository.DoctoralMobilityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DoctoralMobilityService {
    private final DoctoralMobilityRepository doctoralMobilityRepository;

    public List<DoctoralMobility> getAllDoctoralMobilities() {
        return doctoralMobilityRepository.findAll();
    }

    public DoctoralMobility getDoctoralMobilityById(Long id){
       return doctoralMobilityRepository
               .findById(id).orElseThrow(() ->
                       new NotFoundException("Doctoral Mobility with id not found! " + id));
    }

    public DoctoralMobility createDoctoralMobility(DoctoralMobility doctoralMobility) {
        return this.doctoralMobilityRepository.save(doctoralMobility);
    }

    public DoctoralMobility updateDoctoralMobility(DoctoralMobility doctoralMobility) {
        DoctoralMobility existing = doctoralMobilityRepository
                .findById(doctoralMobility.getId())
                .orElseThrow(() ->
                        new NotFoundException("Doctoral Mobility with Id now found " + doctoralMobility.getId()));

        existing.setDescription(doctoralMobility.getDescription());
        return this.doctoralMobilityRepository.save(doctoralMobility);
    }

    public void deleteDoctoralMobilityById(Long id) {
        doctoralMobilityRepository.deleteById(doctoralMobilityRepository
                .findById(id)
                .orElseThrow(() ->
                        new NotFoundException("Doctoral Mobility with Id now found " + id)).getId());
    }
}
