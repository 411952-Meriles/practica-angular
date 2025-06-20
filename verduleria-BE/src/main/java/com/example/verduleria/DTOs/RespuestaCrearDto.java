package com.example.verduleria.DTOs;

import com.example.verduleria.Entities.RespuestaEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RespuestaCrearDto {
    private Long preguntaId;
    private String contenido;

    public RespuestaCrearDto(RespuestaEntity respuestaEntity){
        this.preguntaId=respuestaEntity.getPregunta().getId();
        this.contenido=respuestaEntity.getContenido();

    }
}
