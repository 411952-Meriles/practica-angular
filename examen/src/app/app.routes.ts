import { Routes } from '@angular/router';
import { Encuestas } from './components/encuestas/encuestas';
import { Estadistica } from './components/estadistica/estadistica';
import { Respuesta } from './components/respuesta/respuesta';
import { FormPruba } from './components/form-pruba/form-pruba';

export const routes: Routes = [
    {
        path: "",
        redirectTo: "encuestas",
        pathMatch: "full"
    },
    {
        path: "encuestas",
        component: Encuestas
    },
    {
        path: "estadisticas/:id",
        component: Estadistica
    },
    {
        path: "responder/:id",
        component: Respuesta
    },
    {
        path: "form",
        component: FormPruba
    },
    {
        path: "*",
        redirectTo: "encuestas"
    }
];
