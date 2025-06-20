import { Component, inject, OnDestroy, OnInit } from '@angular/core';
import { EstadisticaEncuestaDTO } from '../../interfaces/models';
import { Api } from '../../services/api';
import { Subscription } from 'rxjs';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-estadistica',
  imports: [],
  templateUrl: './estadistica.html',
  styleUrl: './estadistica.css'
})
export class Estadistica implements OnInit, OnDestroy {
    estadistica: EstadisticaEncuestaDTO | null = null
    subscripciones: Subscription = new Subscription();

    private route = inject(ActivatedRoute)
    private apiService = inject(Api)

    ngOnInit(): void {
        //Busca el parametro con nombre "id" en la ruta
        const id = this.route.snapshot.paramMap.get("id");

        if (id) {
            this.subscripciones.add(
                this.apiService.getEstadisticaPorId(id).subscribe({
                    next: (estadisticaDto: EstadisticaEncuestaDTO) => {
                        this.estadistica = estadisticaDto
                    },
                    error: (error) => {
                        console.error("Error al obtener la estadistica: ", error)
                    }
                })
            )
        }
    }

    ngOnDestroy(): void {
        this.subscripciones.unsubscribe()
    }
}
