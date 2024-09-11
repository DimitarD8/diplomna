package com.example.erasmus_programs.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "mobility")
public class Mobility {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "user_type")
    private String userType;

    @Column(name = "type")
    private String type;

    @OneToMany(mappedBy = "mobility", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Document> documents  = new HashSet<>();

    public void addDocument(Document document) {
        documents.add(document);
        document.setMobility(this);
    }

    // Ensure you have a similar method for removing documents if needed
    public void removeDocument(Document document) {
        documents.remove(document);
        document.setMobility(null);
    }

}
