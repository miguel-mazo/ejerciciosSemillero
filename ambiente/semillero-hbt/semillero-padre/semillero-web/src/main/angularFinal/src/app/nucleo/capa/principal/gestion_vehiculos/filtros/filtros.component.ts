import { Component, OnInit } from '@angular/core';
import { VehiculoDTO } from '../modelo/vehiculoDTO';

@Component({
  selector: 'app-vehiculos-filtros',
  templateUrl: './filtros.component.html'
})
export class FiltrosComponent implements OnInit {

  public mostrarFormulario:boolean;
  public vehiculo : VehiculoDTO;

  constructor() { }

  ngOnInit() {
    this.mostrarFormulario = false;
    this.vehiculo = {
      marca: '',
      linea: '',
      placa: '',
      modelo: '',
      color: ''
    };
  }

  mostrarTabla(){
  	this.mostrarFormulario = true;
  }
  
  ocultar(){
  	this.mostrarFormulario = false;
  }

}
