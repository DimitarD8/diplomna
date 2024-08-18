package com.example.erasmus_programs.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "training")
public class Training {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "doctoralMobility_id")
    @JsonBackReference
    private DoctoralMobility doctoralMobility;

    @ManyToOne
    @JoinColumn(name = "studentMobility_id")
    @JsonBackReference
    private StudentMobility studentMobility;

    @ManyToOne
    @JoinColumn(name = "teacherMobility_id")
    @JsonBackReference
    private TeacherMobility teacherMobility;
}
