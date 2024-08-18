package com.example.erasmus_programs.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "doctoralMobility")
public class DoctoralMobility {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "doctoralMobility", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Practice> practice;

    @OneToMany(mappedBy = "doctoralMobility", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Training> training;

    @OneToMany(mappedBy = "doctoralMobility", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<IntensiveShortTermTraining> intensiveShortTermTraining;

    @OneToMany(mappedBy = "doctoralMobility", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Document> documents;
}
