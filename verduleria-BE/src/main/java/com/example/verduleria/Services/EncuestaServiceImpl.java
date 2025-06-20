package com.example.verduleria.Services;

import com.example.verduleria.Controllers.EncuestaController;
import com.example.verduleria.DTOs.*;
import com.example.verduleria.Entities.EncuestaEntity;
import com.example.verduleria.Entities.PreguntaEntity;
import com.example.verduleria.Entities.RespuestaEntity;
import com.example.verduleria.Respositories.EncuestaRepository;
import com.example.verduleria.Respositories.PreguntaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Transient;
import org.hibernate.annotations.NotFound;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EncuestaServiceImpl {

    EncuestaRepository er;
    PreguntaRepository pr;
    public EncuestaServiceImpl(EncuestaRepository er,PreguntaRepository pr){
        this.er=er;
        this.pr=pr;
    }

    /// ////////////////////////////////////////////////////GET ALL

    public List<EncuestaSinPregDto> getAll(){
        List<EncuestaEntity> EncuestaEntityList=er.findAll();
        List<EncuestaSinPregDto> EncuestaDtoList=new ArrayList<>();

        for(EncuestaEntity encuestaEntity:EncuestaEntityList){

            EncuestaDtoList.add(new EncuestaSinPregDto(encuestaEntity));
        }

        return EncuestaDtoList;
    }


    /// /////////////////////////////////////////////////////////CREAR

    public EncuestaDto crear(EncuestaDto encuestaDto) {
        EncuestaEntity encuestaEntity = new EncuestaEntity();
        encuestaEntity.setTitulo(encuestaDto.getTitulo());

        // Mapeo de preguntas
        for (PreguntaDto preguntaDto : encuestaDto.getPreguntas()) {
            PreguntaEntity pregunta = new PreguntaEntity();
            pregunta.setContenido(preguntaDto.getContenido());
            encuestaEntity.addPregunta(pregunta);  // aquí se asigna encuesta a pregunta
        }

        return new EncuestaDto(er.save(encuestaEntity));
    }

    /// //////////////////////////////////////////getById

    public EncuestaDto getById(Long id){
        Optional<EncuestaEntity> encuestaEntityOptional=er.findById(id);

        EncuestaEntity encuestaEntity=encuestaEntityOptional.orElseThrow(()->
            new ResponseStatusException(HttpStatus.NOT_FOUND,"encuesta no encontrada")
        );

        return new EncuestaDto(encuestaEntity);
    }

    /// /////////////////////////////////////////cargar respuestas

    public List<RespuestaCrearDto> cargarRespuestas(RespuestaCrearRequest respuestaCrearRequest){
        Optional<EncuestaEntity> encuestaEntityOptional=er.findById(respuestaCrearRequest.getEncuestaId());
        EncuestaEntity encuestaEntity=encuestaEntityOptional.orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"no se encontro la encuesta"));
        List<RespuestaCrearDto> respuestaCrearDtos=new ArrayList<>();

        for(RespuestaCrearDto respuestaCrearDto:respuestaCrearRequest.getRespuestas()){
            Optional<PreguntaEntity> preguntaEntityOptional=pr.findById(respuestaCrearDto.getPreguntaId());
            PreguntaEntity preguntaEntity=preguntaEntityOptional.orElseThrow(()->
                    new ResponseStatusException(HttpStatus.NOT_FOUND,"pregunta no encontrada"));

            RespuestaEntity respuestaEntity=new RespuestaEntity();

            respuestaEntity.setFechaRespuesta(LocalDateTime.now());
            respuestaEntity.setContenido(respuestaCrearDto.getContenido());
            respuestaEntity.setPregunta(preguntaEntity);

            preguntaEntity.addRespuesta(respuestaEntity);

            respuestaCrearDtos.add(respuestaCrearDto);//esta lista la devuelvo para mostrar
            //las respuestas que pudieron crearse
        }
        er.save(encuestaEntity);

        return respuestaCrearDtos;
    }

    public EncuestaEstadistica estadistica(Long id){
        Optional<EncuestaEntity> encuestaEntityOptional=er.findById(id);

        EncuestaEntity encuestaEntity=encuestaEntityOptional.orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"encuesta no encontrada."));

        return new EncuestaEstadistica(encuestaEntity);
    }
}
