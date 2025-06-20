import { Component, inject, OnDestroy, OnInit } from '@angular/core';
import { Api } from '../../services/api';
import { EncuestaDetalleDTO, NuevaRespuestaDTO } from '../../interfaces/models';
import { Subscription } from 'rxjs';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import {FormsModule} from "@angular/forms"

@Component({
  selector: 'app-respuesta',
//   FormsModule para el formulario y RouterLink para el boton de volver
  imports: [FormsModule, RouterLink],
  templateUrl: './respuesta.html',
  styleUrl: './respuesta.css'
})
export class Respuesta implements OnInit, OnDestroy {
    

    encuesta: EncuestaDetalleDTO | null = null;
    respuesta: NuevaRespuestaDTO = {
        encuestaId: 0,
        respuestas: []
    }

    private subscripciones: Subscription = new Subscription();
    private route = inject(ActivatedRoute);
    private apiService = inject(Api)

    ngOnInit(): void {
        const id = this.route.snapshot.paramMap.get("id")

        if (id) {
            this.respuesta.encuestaId = Number(id)
            this.subscripciones.add(
                this.apiService.getEncuestasPorId(id).subscribe({
                    next: (data: EncuestaDetalleDTO) => {
                        this.encuesta = data

                        data.preguntas.forEach(p => {
                            this.respuesta.respuestas.push({
                                preguntaId: p.id,
                                contenido: ""
                            })
                        })
                    },
                    error: (error) => {
                        console.error(error)
                    }
                })
            )
        }
    }

    ngOnDestroy(): void {
        this.subscripciones.unsubscribe()
    }

    enviarFormulario() {
        this.apiService.enviarRespuestas(this.respuesta).subscribe({
            next: () => {
                console.log("Respuesta enviada con exito")
            },
            error: (error) => {
                console.error("Error al enviar la respuesta:", error)
            }
        })
    }
}
