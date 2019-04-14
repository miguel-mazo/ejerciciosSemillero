import { Component, OnInit } from '@angular/core';
import { VehiculoServicioDTO } from '../modelo/vehiculoServicioDTO';
import { ConsultaVehiculosService } from '../../../../../nucleo/servicios/consulta-vehiculos-servicio/consulta.vehiculo.service'
import { LineaServicioDTO } from '../modelo/lineaServicioDTO';
import { MarcaServicioDTO } from '../modelo/marcaServicioDTO';

@Component({
  selector: 'app-vehiculos-filtros',
  templateUrl: './filtros.component.html'
})
export class FiltrosComponent implements OnInit {

  public mostrarFormulario:boolean;
  public vehiculo : VehiculoServicioDTO;

  public marcas : MarcaServicioDTO[];
  public idMarca : number;
  public lineas : LineaServicioDTO[];
  public idLinea : number;

  public listaVehiculosDTO : VehiculoServicioDTO[];

  constructor(private vehiculosService: ConsultaVehiculosService) { }

  ngOnInit() {
    this.mostrarFormulario = false;
    this.idLinea = null;
    this.idMarca = null;
    
    this.consultarMarcas();

    this.vehiculo = {
      idVehiculo: null,
      linea: null,
      placa: '',
      modelo: null
    };
  }

  public consultarMarcas(){
    this.marcas = null;
    this.idMarca = null;
    this.vehiculosService.consultarMarcas().subscribe(
      result => {
        this.marcas = result;
        console.log('resultado servicio.... ' + this.marcas);
      },error => {
        console.log(error);
      }
    );
  }

  public consultarLineas() {
    this.lineas = null;
    this.idLinea = null;
    this.vehiculosService.consultarLineasPorMarca(this.idMarca).subscribe(
      result => {
        this.lineas = result;
        console.log('resultado servicio.... ' + this.lineas);
      },error => {
        console.log(error);
      }
    );
 }

 public consultar(){
   this.mostrarTabla();
   this.vehiculosService.consultarMarcaLinea(this.idMarca, this.idLinea).subscribe(
     result => {
       this.listaVehiculosDTO = result;
       console.log('resultado servicio.... ' + this.listaVehiculosDTO);
     },error => {
      console.log(error);
    }
    );
  }

  public editar(vehiculo : VehiculoServicioDTO){
    console.log(vehiculo);
    this.vehiculosService.editarVehiculo(vehiculo).subscribe(
      result => {
        this.consultar();
      },error => {
       console.log(error);
     }
     );
  }

  public borrar(vehiculo : VehiculoServicioDTO){
    this.vehiculosService.borrarVehiculo(vehiculo).subscribe(
      result => {
        this.consultar();
      },error => {
       console.log(error);
     }
     );
  }

  mostrarTabla(){
  	this.mostrarFormulario = true;
  }
  
  ocultar(){
  	this.mostrarFormulario = false;
  }

}
