package com.example.verduleria.DTOs;

import com.example.verduleria.Entities.EncuestaEntity;
import com.example.verduleria.Entities.PreguntaEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class EncuestaEstadistica {
    private Long id;
    private String titulo;
    private List<PreguntaEstadistica> preguntas=new ArrayList<>();

    public EncuestaEstadistica(EncuestaEntity encuestaEntity){
        this.id=encuestaEntity.getId();
        this.titulo=encuestaEntity.getTitulo();
        for(PreguntaEntity preguntaEntity:encuestaEntity.getPreguntas()){
            preguntas.add(new PreguntaEstadistica(preguntaEntity));
        }

    }
}
