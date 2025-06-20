package com.example.verduleria.DTOs;

import com.example.verduleria.Entities.EncuestaEntity;
import com.example.verduleria.Entities.PreguntaEntity;
import com.example.verduleria.Services.EncuestaServiceImpl;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class EncuestaDto {
    private Long id;
    private String titulo;
    private List<PreguntaDto> preguntas=new ArrayList<>();

    public EncuestaDto(EncuestaEntity encuestaEntity){
        this.id=encuestaEntity.getId();
        this.titulo=encuestaEntity.getTitulo();

        for(PreguntaEntity preguntaEntity:encuestaEntity.getPreguntas()){
            PreguntaDto preguntaDato= new PreguntaDto(preguntaEntity);
            preguntas.add(preguntaDato);
        }

    }

    public EncuestaDto(Long id,String titulo,List<PreguntaDto> preguntas){
        this.id=id;
        this.titulo=titulo;
        this.preguntas=preguntas;
    }
}
