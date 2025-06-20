package com.example.verduleria.DTOs;

import com.example.verduleria.Entities.PreguntaEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PreguntaEstadistica {
    private Long id;
    private String contenido;
    private int cantRespuestas=0;

    public PreguntaEstadistica(PreguntaEntity preguntaEntity){
        this.id=preguntaEntity.getId();
        this.contenido=preguntaEntity.getContenido();
        this.cantRespuestas=preguntaEntity.getRespuestas().size();
    }
}
