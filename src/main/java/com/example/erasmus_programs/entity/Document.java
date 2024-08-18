package com.example.erasmus_programs.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "documents")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "file_name", nullable = false)
    private String fileName;

    @Lob
    @Column(name = "data", nullable = false)
    private byte[] data;

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
