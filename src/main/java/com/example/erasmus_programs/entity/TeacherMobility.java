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
@Table(name = "teacherMobility")
public class TeacherMobility {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "teacherMobility", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Practice> practice;

    @OneToMany(mappedBy = "teacherMobility", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Training> training;

    @OneToMany(mappedBy = "teacherMobility", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Document> documents;
}
