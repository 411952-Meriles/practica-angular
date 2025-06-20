package com.example.verduleria.Controllers;

import com.example.verduleria.DTOs.RespuestaCrearDto;
import com.example.verduleria.DTOs.RespuestaCrearRequest;
import com.example.verduleria.Services.EncuestaServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RespuestaController {

    private EncuestaServiceImpl es;

    public RespuestaController(EncuestaServiceImpl es){
        this.es=es;
    }


    @PostMapping("api/respuestas")
    public List<RespuestaCrearDto> crear(@RequestBody RespuestaCrearRequest respuestaCrearRequest){
        return es.cargarRespuestas(respuestaCrearRequest);
    }
}
