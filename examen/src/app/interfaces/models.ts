export interface EncuestaDTO {
    id: number;
    titulo: string;
    cantidadPreguntas: number;
    cantidadRespuestas: number;
}

export interface PreguntasDTO {
    id: number;
    contenido: string;
}

export interface EncuestaDetalleDTO {
    id: number;
    titulo: string;
    preguntas: PreguntasDTO[];
}

export interface RespuestaIndividualDTO {
    preguntaId: number;
    contenido: string;
}

export interface NuevaRespuestaDTO {
    encuestaId: number;
    respuestas: RespuestaIndividualDTO[];
}

export interface EstadisticaPreguntaDTO {
    preguntaId: number;
    contenidoPregunta: string;
    cantidadTotalRespustas: number;
}

export interface EstadisticaEncuestaDTO {
    encuestaId: number;
    tituloEncuensta: string;
    estadisticasPreguntas: EstadisticaPreguntaDTO[];
}