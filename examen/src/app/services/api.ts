import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { EncuestaDetalleDTO, EncuestaDTO, EstadisticaEncuestaDTO, NuevaRespuestaDTO } from '../interfaces/models';

@Injectable({
  providedIn: 'root'
})
export class Api {
    apiUrl = "http://localhost:8080/api"
    private http = inject(HttpClient) 

    // Se puede crear en el constructor tambien 
    // constructor(httpClient: HttpClient) {
    // }

    getEncuestas() {
        return this.http.get<EncuestaDTO[]>(`${this.apiUrl}/encuestas`)
    }

    //Parametro id string porque viene de los parametros
    getEstadisticaPorId(id: string) {
        return this.http.get<EstadisticaEncuestaDTO>(`${this.apiUrl}/encuestas/${id}/estadisticas`)
    }

    //Parametro id string porque viene de los parametros
    getEncuestasPorId(id: string) {
        return this.http.get<EncuestaDetalleDTO>(`${this.apiUrl}/encuestas/${id}`)
    }

    enviarRespuestas(respuesta: NuevaRespuestaDTO) {
        return this.http.post<void>(`${this.apiUrl}/respuestas`, respuesta)
    }
}
