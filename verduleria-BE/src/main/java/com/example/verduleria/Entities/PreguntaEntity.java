package com.example.verduleria.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="PREGUNTAS")
public class PreguntaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="contenido")
    private String contenido;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name="encuesta_id",nullable = false)
    private EncuestaEntity encuesta;

    @OneToMany(mappedBy = "pregunta",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<RespuestaEntity> respuestas=new ArrayList<>();

    public void addRespuesta(RespuestaEntity r) {
        respuestas.add(r);
        r.setPregunta(this);//"this" pasa el objeto actual
    }
}
