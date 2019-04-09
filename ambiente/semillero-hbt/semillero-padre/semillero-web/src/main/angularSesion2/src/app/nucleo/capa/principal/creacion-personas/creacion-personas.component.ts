import { Component, OnInit } from '@angular/core';
import { PersonaDTO } from '../apoyo/modelo/personaDTO';

@Component({
  selector: 'app-creacion-personas',
  templateUrl: './creacion-personas.component.html'
})
export class CreacionPersonasComponent implements OnInit {
  
  public persona : PersonaDTO;
  public personas : PersonaDTO[];

  public mostrarFormulario : boolean;

  public header : string = 'Crear personas';
  public id : number = 1;
  public nombre : string = 'Juan';
  public apellidos : string = 'Perez';
  public tipoIdentificacion : string = 'cedula';
  public formHidden : boolean = false;
  
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
      rol: ''
    };

    this.personas = [];
    this.mostrarFormulario = true;

  }

  public mostrar(){
    
  }

  public ocultar(){

  }

  public ingresar(){
    this.personas.push(this.persona);
  }

  private borrar(){

  }

}
