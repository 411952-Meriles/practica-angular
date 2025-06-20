import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-form-pruba',
  imports: [FormsModule],
  templateUrl: './form-pruba.html',
  styleUrl: './form-pruba.css'
})
export class FormPruba {
    usuario = {
        nombre: ""
    }

    onSubmit() {
        console.log(this.usuario)
    }
}
