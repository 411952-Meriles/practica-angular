package com.example.verduleria.DTOs;

import com.example.verduleria.Entities.PreguntaEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PreguntaDto {
    private Long id;
    private String contenido;

    public PreguntaDto(PreguntaEntity preguntaEntity){
        this.id=preguntaEntity.getId();
        this.contenido=preguntaEntity.getContenido();
    }

    public PreguntaDto(Long id,String contenido){
        this.id=id;
        this.contenido=contenido;
    }
}
