package com.example.verduleria.DTOs;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class RespuestaCrearRequest {
    private Long encuestaId;
    private List<RespuestaCrearDto> respuestas=new ArrayList<>();


}
