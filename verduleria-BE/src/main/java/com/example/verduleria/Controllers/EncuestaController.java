package com.example.verduleria.Controllers;

import com.example.verduleria.DTOs.EncuestaDto;
import com.example.verduleria.DTOs.EncuestaEstadistica;
import com.example.verduleria.DTOs.EncuestaSinPregDto;
import com.example.verduleria.Entities.EncuestaEntity;
import com.example.verduleria.Services.EncuestaServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class EncuestaController {

    private EncuestaServiceImpl es;
    public EncuestaController(EncuestaServiceImpl es){
        this.es=es;
    }

    @GetMapping("/api/encuestas")
    public List<EncuestaSinPregDto> getAll(){
        return es.getAll();
    }

    @PostMapping("/api/encuestas")
    public EncuestaDto crear(@RequestBody EncuestaDto encuesta){
        return es.crear(encuesta);
    }

    @GetMapping("/api/encuestas/{id}")
    public EncuestaDto getById(@PathVariable Long id){
        return es.getById(id);
    }

    @GetMapping("/api/encuestas/{id}/estadisticas")
    public EncuestaEstadistica estadistica(@PathVariable Long id){
        return es.estadistica(id);
    }
}
