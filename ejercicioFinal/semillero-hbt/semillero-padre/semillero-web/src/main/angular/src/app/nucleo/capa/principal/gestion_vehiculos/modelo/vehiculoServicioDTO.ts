import { LineaServicioDTO } from './lineaServicioDTO';

export interface VehiculoServicioDTO {
  //Los datos son iguales que el DTO en Java
  idVehiculo: number;
  linea: LineaServicioDTO;
  placa: string;
  modelo: number;
}