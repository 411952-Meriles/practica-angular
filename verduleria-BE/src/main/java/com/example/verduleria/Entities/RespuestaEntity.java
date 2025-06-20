package com.example.verduleria.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name="respuestas")
public class RespuestaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name="pregunta_id",nullable = false)
    private PreguntaEntity pregunta;

    @Column(name="contenido",nullable = false)
    private String contenido;

    @Column(name="fecha",nullable = false)
    private LocalDateTime fechaRespuesta;
}
