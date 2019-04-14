import { Component, OnInit } from '@angular/core';
import { VehiculoServicioDTO } from './modelo/vehiculoServicioDTO';

@Component({
  selector: 'app-gestion_vehiculos',
  templateUrl: './gestion_vehiculos.component.html'
})
export class GestionVehiculosComponent implements OnInit {
  public vehiculo:VehiculoServicioDTO;
  
  constructor() { }

  ngOnInit() {
  	this.vehiculo = { idVehiculo: null, linea: null, placa: '123ABC', modelo: null };
  }

}
