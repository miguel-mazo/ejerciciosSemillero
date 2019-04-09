import { Component, OnInit } from '@angular/core';

import { PersonaDTO } from './modelo/personaDTO';

@Component({
  selector: 'app-apoyo',
  templateUrl: './apoyo.component.html'
})
export class ApoyoComponent implements OnInit {

  public persona : PersonaDTO;
  public personas : PersonaDTO[];

  public mostrarFormulario : boolean;

  constructor() { }

  ngOnInit() {
    
    this.persona = {

      id : '0',
      nombre : '',
      apellido : '',
      tipoIdentificacion : '',
      numeroIdentificacion : '',
      numeroTelefonico : 0,
      edad : 0,
      fechaNacimiento: '',
      mayorEdad : false,
      estado : '',
      sexo : '',
      rol : ''
    };

    this.personas = [];
    this.mostrarFormulario = true;
  }

  public mostrar(){
    
  }

  public ocultar(){

  }

  public guardar(){
    this.personas.push(this.persona);
  }

  private borrar(){

  }

}
