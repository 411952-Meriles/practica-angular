import { Component, inject, OnDestroy, OnInit } from '@angular/core';
import { Api } from '../../services/api';
import { TablaEncuestas } from "../tabla-encuestas/tabla-encuestas";
import { EncuestaDTO } from '../../interfaces/models';
import { Subscription } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-encuestas',
  imports: [TablaEncuestas],
  templateUrl: './encuestas.html',
  styleUrl: './encuestas.css'
})
export class Encuestas implements OnInit, OnDestroy {
    private apiService = inject(Api)
    private router = inject(Router)

    listadoEncuestas: EncuestaDTO[] = [];
    subscriptions: Subscription = new Subscription();

    //Implementa la interface OnInit
    ngOnInit(): void {
        this.subscriptions.add(
            this.apiService.getEncuestas().subscribe({
                next: (encuestas: EncuestaDTO[]) => {
                    this.listadoEncuestas = encuestas;
                },
                error: (error) => {
                    console.error("Error al obtener las encuestas:", error);
                }
            })
        )
    }

    //Implementa la interface OnDestroy
    ngOnDestroy(): void {
        //Limpia todas las subscripciones
        this.subscriptions.unsubscribe();
    }

    redirigirEstadistica(id: number) {
        this.router.navigate(["/estadisticas", id])
    }

    redirigirRespuestas(id: number) {
        this.router.navigate(["/responder", id])
    }
}
