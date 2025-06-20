package com.example.verduleria.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="ENCUESTAS")
public class EncuestaEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id",nullable = false,updatable = false)
    private Long id;

    @Column(name="titulo",nullable = false)
    private String titulo;

    @OneToMany(mappedBy = "encuesta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PreguntaEntity> preguntas = new ArrayList<>();

    public void addPregunta(PreguntaEntity p) {
        preguntas.add(p);
        p.setEncuesta(this);
    }

    public void removePregunta(PreguntaEntity p) {
        preguntas.remove(p);
        p.setEncuesta(null);
    }

}
