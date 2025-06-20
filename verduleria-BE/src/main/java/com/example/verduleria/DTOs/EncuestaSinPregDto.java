package com.example.verduleria.DTOs;

import com.example.verduleria.Entities.EncuestaEntity;
import com.example.verduleria.Entities.PreguntaEntity;
import com.example.verduleria.Entities.RespuestaEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EncuestaSinPregDto {
    private Long id;
    private String titulo;
    private int cantidadPreguntas=0;
    private int cantidadRespuestas=0;

    public EncuestaSinPregDto(EncuestaEntity encuestaEntity){
        this.id=encuestaEntity.getId();
        this.titulo= encuestaEntity.getTitulo();
        this.cantidadPreguntas=encuestaEntity.getPreguntas().size();

        for(PreguntaEntity preg:encuestaEntity.getPreguntas()){
            this.cantidadRespuestas+=preg.getRespuestas().size();
        }
    }

    public EncuestaSinPregDto(Long id,String titulo){
        this.id=id;
        this.titulo=titulo;
    }
}
